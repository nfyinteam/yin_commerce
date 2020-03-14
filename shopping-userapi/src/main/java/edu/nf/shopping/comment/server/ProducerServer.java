package edu.nf.shopping.comment.server;

import edu.nf.shopping.config.RabbitConfig;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Bull fighters
 * @date 2020/3/14
 */
@Service
public class ProducerServer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送文本消息
     * @param message
     */
    public void sendMessage(Object message){
        //创建消息的唯一ID
        CorrelationData correlationData = new CorrelationData();
        //消息的ID
        correlationData.setId(UUID.randomUUID().toString());
        //发送消息
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "order.message", message, correlationData);
    }
}