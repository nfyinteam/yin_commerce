package edu.nf.shopping.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Bull fighters
 * @date 2020/3/14
 */
@Configuration
public class RabbitConfig {

    public static final String EXCHANGE_NAME = "order.exchange";
    public static final String QUEUE_NAME = "order.queue";
    public static final String ROUTER_KEY = "order.*";

    /**
     * 装配Topic类型的Exchange
     * 也可以装配其他类型如：DirectExchange、FanoutExchange
     */
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }

    /**
     * 装配消息队列
     * Queue构造方法第一个参数指定Queue的名称，第二个参数表示是否持久化消息
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }

    /**
     * 将queue绑定到exchange
     */
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(exchange()).with(ROUTER_KEY);
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}