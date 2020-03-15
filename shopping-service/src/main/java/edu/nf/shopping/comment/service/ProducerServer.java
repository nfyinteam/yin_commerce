package edu.nf.shopping.comment.service;

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
     * @param aaa
     */
    public void sendMessage(Object aaa,Integer delayTime){
        //创建消息的唯一ID
        CorrelationData correlationData = new CorrelationData();
        //消息的ID
        correlationData.setId(UUID.randomUUID().toString());
        //发送消息
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "delay.message", aaa, message -> {
            //设置延迟时间
            message.getMessageProperties().setDelay(delayTime);
            return message;
        }, correlationData);
    }
}