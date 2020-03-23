package edu.nf.shopping.message;

import com.rabbitmq.client.Channel;
import edu.nf.shopping.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @author Bull fighters
 * @date 2020/3/14
 */
@Service
public class ConsumerServer {
    /**
     * 使用自定义消息转换器
     * 使用@RabbitListener注解进行监听，通过queues属性指定要从哪个queue中消费消息
     * @Payload注解标注的参数为转换后的消息对象
     * @Headers注解标注的参数为消息头
     * @param message 消息体内容
     * @param headers 消息头
     * @param channel 消息通道
     */
    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void receiveMessage(@Payload Object message,
                               @Headers Map<String, Object> headers,
                               Channel channel) throws IOException {
        System.out.println("接收消息：" + message);
        //当手动确认签收时，需要自行给rabbitmq回馈一条消息，这条消息已经处理完毕
        //从headers获取一个签收标签
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        //确认签收，basicAck方法参入一个签收标签，第二个参数表示是否支持批量签收，false表示单个签收
        channel.basicAck(deliveryTag, false);
    }
}