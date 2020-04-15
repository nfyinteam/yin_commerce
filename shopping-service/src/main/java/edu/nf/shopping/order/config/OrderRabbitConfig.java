package edu.nf.shopping.order.config;

import edu.nf.shopping.config.RabbitConfig;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Achine
 * @date 2020/4/8
 */
@Configuration
public class OrderRabbitConfig {

    public static final String ORDER_DETAILS_CREATE_QUEUE = "order.details.create.queue";
    public static final String ORDER_INIT_QUEUE = "order.init.queue";

    public static final String ORDER_DETAILS_CREATE_ROUTER_KEY = "order.details.create";
    public static final String ORDER_INIT_ROUTER_KEY = "order.init";

    /**
     * 装配消息队列
     */

    @Bean
    public Queue orderDetailsCreateQueue(){
        return new Queue(ORDER_DETAILS_CREATE_QUEUE, true);
    }

    @Bean
    public Queue orderInitQueue(){
        return new Queue(ORDER_INIT_QUEUE, true);
    }

    /**
     * 将queue绑定到exchange交换机
     */

    @Bean
    public Binding orderDetailsCreateBinding(@Qualifier("orderDetailsCreateQueue") Queue queue,
                                             @Qualifier("directExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ORDER_DETAILS_CREATE_ROUTER_KEY).noargs();
    }

    @Bean
    public Binding orderInitBinding(@Qualifier("orderInitQueue") Queue queue,
                                    @Qualifier("directExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ORDER_INIT_ROUTER_KEY).noargs();
    }
}
