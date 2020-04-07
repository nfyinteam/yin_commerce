package edu.nf.shopping.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bull fighters
 * @date 2020/3/14
 */
@Configuration
public class RabbitConfig {

    public static final String EXCHANGE_NAME = "exchange";

    public static final String PRAISE_QUEUE = "praise.queue";
    public static final String COMMENT_QUEUE = "comment.queue";
    public static final String MESSAGE_QUEUE = "message.queue";
    public static final String ORDER_DETAILS_CREATE_QUEUE = "order.details.create.queue";
    public static final String ORDER_INIT_QUEUE = "order.init.queue";

    public static final String PRAISE_ROUTER_KEY = "praise.message";
    public static final String COMMENT_ROUTER_KEY = "comment.message";
    public static final String MESSAGE_ROUTER_KEY = "message.message";
    public static final String ORDER_DETAILS_CREATE_ROUTER_KEY = "order.details.create";
    public static final String ORDER_INIT_ROUTER_KEY = "order.init";

    /**
     * 自定义Exchange，设置交换机类型
     */
    @Bean
    public CustomExchange exchange() {
        Map<String, Object> params = new HashMap<>();
        params.put("x-direct-type", "direct");
        return new CustomExchange(EXCHANGE_NAME, "direct", true, false, params);
    }

    /**
     * 装配消息队列
     * Queue构造方法第二个参数表示是否持久化消息
     * @return
     */
    @Bean
    public Queue praiseQueue(){
        return new Queue(PRAISE_QUEUE, true);
    }

    @Bean
    public Queue commentQueue(){
        return new Queue(COMMENT_QUEUE, true);
    }

    @Bean
    public Queue messageQueue(){
        return new Queue(MESSAGE_QUEUE, true);
    }

    @Bean
    public Queue orderDetailsCreateQueue(){
        return new Queue(ORDER_DETAILS_CREATE_QUEUE, true);
    }

    @Bean
    public Queue orderInitQueue(){
        return new Queue(ORDER_INIT_QUEUE, true);
    }

    /**
     * 将queue绑定到exchange
     */
    @Bean
    public Binding praiseBinding(@Qualifier("praiseQueue") Queue queue,
                                 @Qualifier("exchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(PRAISE_ROUTER_KEY).noargs();
    }

    @Bean
    public Binding commentBinding(@Qualifier("commentQueue") Queue queue,
                                  @Qualifier("exchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(COMMENT_ROUTER_KEY).noargs();
    }

    @Bean
    public Binding messageBinding(@Qualifier("messageQueue") Queue queue,
                                  @Qualifier("exchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(MESSAGE_ROUTER_KEY).noargs();
    }

    @Bean
    public Binding orderDetailsCreateBinding(@Qualifier("orderDetailsCreateQueue") Queue queue,
                                             @Qualifier("exchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ORDER_DETAILS_CREATE_ROUTER_KEY).noargs();
    }

    @Bean
    public Binding orderInitBinding(@Qualifier("orderInitQueue") Queue queue,
                                             @Qualifier("exchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ORDER_INIT_ROUTER_KEY).noargs();
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