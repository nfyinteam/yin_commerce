package edu.nf.shopping.order.service.impl;

import com.rabbitmq.client.Channel;
import edu.nf.shopping.order.config.OrderRabbitConfig;
import edu.nf.shopping.order.dao.OrderDao;
import edu.nf.shopping.order.entity.OrderInfo;
import edu.nf.shopping.order.exception.OrderException;
import edu.nf.shopping.order.service.CommitLatterOrderInfoService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Achine
 * @date 2020/4/5
 */
@Service("commitLatterOrderInfoService")
public class CommitLatterOrderInfoServiceImpl implements CommitLatterOrderInfoService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    @CachePut(value = "orderCache", key = "#orderInfo.orderId")
    public OrderInfo updateOrderInfo(OrderInfo orderInfo) {
        try{
            if(orderInfo == null){
                throw new OrderException("订单信息不能为空");
            }
            orderDao.updateOrderInfo(orderInfo);
            return orderInfo;
        }catch (Exception e){
            throw new OrderException(e);
        }
    }

    /**
     消息的消费者：修改订单
     **/
    @RabbitListener(queues = OrderRabbitConfig.ORDER_COMMIT_QUEUE)
    private void orderCommitMessage(OrderInfo orderInfo,
                                @Headers Map<String, Object> headers,
                                Channel channel) throws IOException {
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        try {
            updateOrderInfo(orderInfo);
            String userId = orderInfo.getBuyUser().getUserId();
            //es里的订单列表修改
            channel.basicAck(deliveryTag, false);
        }catch (Exception e){
            channel.basicReject(deliveryTag, false);
        }
    }

    /**
     消息的消费者：修改订单
     **/
    @RabbitListener(queues = OrderRabbitConfig.ORDER_COMMIT_DEAD_QUEUE)
    private void orderCommitDeadMessage(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
