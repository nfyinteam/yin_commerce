package edu.nf.shopping.order.service.impl;

import com.rabbitmq.client.Channel;
import edu.nf.shopping.order.config.OrderRabbitConfig;
import edu.nf.shopping.order.dao.OrderDetailsDao;
import edu.nf.shopping.order.entity.OrderDetails;
import edu.nf.shopping.order.exception.OrderDetailsException;
import edu.nf.shopping.order.service.InitOrderDetailsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Achine
 * @date 2020/4/6
 */
@Service("initOrderDetailsService")
public class InitOrderDetailsServiceImpl implements InitOrderDetailsService {

    @Autowired
    private OrderDetailsDao detailsDao;

    @Override
    public void initOrderDetails(List<OrderDetails> orderDetails) {
        try {
            if(orderDetails.size() == 0 || orderDetails == null){
                throw new OrderDetailsException("该订单明细信息不能为空");
            }
            detailsDao.addOrderDetails(orderDetails);
        }catch (Exception e){
            throw new OrderDetailsException(e);
        }
    }

    /**
     消息的消费者：创建订单
     **/
    @RabbitListener(queues = OrderRabbitConfig.ORDER_INIT_QUEUE)
    public void receiveMessage(List<OrderDetails> orderDetails,
                               @Headers Map<String, Object> headers,
                               Channel channel) throws IOException {
        initOrderDetails(orderDetails);
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);
    }
}
