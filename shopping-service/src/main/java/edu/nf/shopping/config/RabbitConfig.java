package edu.nf.shopping.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bull fighters
 * @date 2020/3/14
 */
/*@Configuration*/
public class RabbitConfig {

    public static final String EXCHANGE_NAME = "delay.exchange";
    public static final String QUEUE_NAME = "delay.queue";
    public static final String ROUTER_KEY = "delay.message";

    /**
     * 自定义Exchange，设置延迟交换机类型
     */
    @Bean
    public CustomExchange delayExchange() {
        Map<String, Object> params = new HashMap<>();
        params.put("x-delayed-type", "direct");
        return new CustomExchange(EXCHANGE_NAME, "x-delayed-message", true, false, params);
    }

    /**
     * 装配消息队列
     * Queue构造方法第二个参数表示是否持久化消息
     * @return
     */
    @Bean
    public Queue queue(){
        return new Queue(QUEUE_NAME, true);
    }

    /**
     * 将queue绑定到exchange
     */
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(delayExchange()).with(ROUTER_KEY).noargs();
    }

    /**
     * 自定义消息转换器
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}