package edu.nf.shopping.order.service.impl;

import com.rabbitmq.client.Channel;
import edu.nf.shopping.config.RabbitConfig;
import edu.nf.shopping.goods.entity.SkuInfo;
import edu.nf.shopping.goods.service.SkuInfoService;
import edu.nf.shopping.order.config.OrderRabbitConfig;
import edu.nf.shopping.order.dao.OrderDao;
import edu.nf.shopping.order.dao.OrderDetailsDao;
import edu.nf.shopping.order.entity.OrderDetails;
import edu.nf.shopping.order.entity.OrderInfo;
import edu.nf.shopping.order.exception.OrderException;
import edu.nf.shopping.order.service.DestroyOrderInfoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @author Achine
 * @date 2020/4/8
 * 创建订单失效，销毁订单
 */
@Service("initDestroyOrderInfoService")
public class InitDestroyOrderInfoServiceImpl implements DestroyOrderInfoService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDetailsDao detailsDao;

    @Autowired
    private SkuInfoService skuInfoService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 根据订单状态为提交中的，设置为已失效
     * @param orderInfo 订单信息
     */
    @Override
    public void destroyOrder(OrderInfo orderInfo) {
        try {
            OrderInfo o = orderDao.getOrderInfoByOrderId(orderInfo.getOrderId());
            if(o != null){
                if(o.getOrderState().equals("确认中") || o.getOrderState().equals("待付款")){
                    //修改状态
                    o.setOrderState("已失效");
                    //恢复库存
                    for(OrderDetails details : orderInfo.getOrderDetails()){
                        SkuInfo skuInfo = skuInfoService.getSkuAllInfoBySkuId(details.getSkuId()).getSkuInfo();
                        skuInfo.setSkuStock(skuInfo.getSkuStock() + details.getSkuNum());
                        skuInfoService.updateSkuInfo(skuInfo);
                    }
                    orderDao.updateOrderInfo(o);
                    if(redisTemplate.opsForValue().get("orderCache::" + o.getOrderId()) != null){
                        redisTemplate.opsForValue().set("orderCache::" + o.getOrderId(), o);
                    }
                    String userId = o.getBuyUser().getUserId();
                    if(redisTemplate.opsForValue().get("orderListCache::" + userId) != null){
                        redisTemplate.opsForValue().set("orderListCache::" + userId, orderDao.listOrderInfo(userId));
                    }
                }
            }
        }catch (Exception e){
            throw new OrderException(e);
        }
    }

    /**
     * 接收消息
     * 这里会延迟接收，也就是在发送端指定的延迟时间后才才进行接收
     */
    @RabbitListener(queues = {OrderRabbitConfig.ORDER_DESTROY_QUEUE, })
    public void receiveMessage(OrderInfo orderInfo,
                               @Headers Map<String, Object> headers,
                               Channel channel) throws IOException {
        destroyOrder(orderInfo);
        //确认签收
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);
    }
}
