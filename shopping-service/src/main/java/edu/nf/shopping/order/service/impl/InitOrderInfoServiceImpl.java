package edu.nf.shopping.order.service.impl;

import com.rabbitmq.client.Channel;
import edu.nf.shopping.comment.entity.Praise;
import edu.nf.shopping.config.RabbitConfig;
import edu.nf.shopping.order.dao.OrderDao;
import edu.nf.shopping.order.entity.OrderDetails;
import edu.nf.shopping.order.entity.OrderInfo;
import edu.nf.shopping.order.exception.OrderException;
import edu.nf.shopping.order.service.InitOrderInfoService;
import edu.nf.shopping.user.dao.UserInfoDao;
import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.util.TimeMillisUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * @author Achine
 * @date 2020/4/5
 */
@Service("initOrderInfoService")
public class InitOrderInfoServiceImpl implements InitOrderInfoService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 初始化订单
     * @param userId 用户编号
     * @return
     */
    @Override
    public OrderInfo initOrderInfo(String userId) {
        try {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOrderId(TimeMillisUtils.getCurrentTimeMillisName());
            if(userId == null || userId == ""){
                throw new OrderException("该用户不能为空");
            }
            UserInfo userInfo = userInfoDao.getUserInfo(userId);
            if(userInfo == null){
                throw new OrderException("该用户不能为空");
            }
            orderInfo.setBuyUser(userInfo);
            orderInfo.setOrderState("确认中");
            orderInfo.setCreateTime(new Date());
            CorrelationData correlationData = new CorrelationData();
            correlationData.setId(orderInfo.getOrderId());
            rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "order.init", orderInfo, correlationData);
            return orderInfo;
        }catch (Exception e){
            throw new OrderException(e);
        }
    }

    /**
     消息的消费者：创建订单
     **/
    @RabbitListener(queues = RabbitConfig.ORDER_INIT_QUEUE)
    public void receiveMessage(OrderInfo orderInfo,
                               @Headers Map<String, Object> headers,
                               Channel channel) throws IOException {
        orderDao.addOrderInfo(orderInfo);
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);
    }
}
