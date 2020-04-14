package edu.nf.shopping.order.config;

import edu.nf.shopping.config.RabbitConfig;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Achine
 * @date 2020/4/8
 */
@Configuration
public class OrderRabbitConfig {

    public static final String ORDER_INIT_QUEUE = "order.init.queue";
    public static final String ORDER_INIT_DEAD_QUEUE = "order.init.dead.queue";
    public static final String ORDER_COMMIT_QUEUE = "order.commit.queue";
    public static final String ORDER_COMMIT_DEAD_QUEUE = "order.commit.dead.queue";
    public static final String ORDER_DESTROY_QUEUE = "order.destroy.queue";
    public static final String ORDER_PAY_DESTROY_QUEUE = "order.pay.destroy.queue";

    public static final String ORDER_INIT_ROUTER_KEY = "order.init";
    public static final String ORDER_INIT_DEAD_ROUTER_KEY = "order.init.dead";
    public static final String ORDER_COMMIT_ROUTER_KEY = "order.commit";
    public static final String ORDER_COMMIT_DEAD_ROUTER_KEY = "order.commit.dead";
    public static final String ORDER_DESTROY_ROUTER_KEY = "order.destroy";
    public static final String ORDER_PAY_DESTROY_ROUTER_KEY = "order.pay.destroy";

    /**
     * 装配消息队列
     */

    @Bean
    public Queue orderInitQueue(){
        Map<String, Object> args = new HashMap<>(2);
        //这里声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", RabbitConfig.DEAD_EXCHANGE_NAME);
        //这里声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", ORDER_INIT_DEAD_ROUTER_KEY);
        return QueueBuilder.durable(ORDER_INIT_QUEUE).withArguments(args).build();
    }

    @Bean
    public Queue orderInitDeadQueue(){
        return new Queue(ORDER_INIT_DEAD_QUEUE, true);
    }

    @Bean
    public Queue orderCommitQueue(){
        Map<String, Object> args = new HashMap<>(2);
        //这里声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", RabbitConfig.DEAD_EXCHANGE_NAME);
        //这里声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", ORDER_COMMIT_DEAD_ROUTER_KEY);
        return QueueBuilder.durable(ORDER_COMMIT_QUEUE).withArguments(args).build();
    }

    @Bean
    public Queue orderCommitDeadQueue(){
        return new Queue(ORDER_COMMIT_DEAD_QUEUE, true);
    }

    @Bean
    public Queue orderDestroyQueue(){
        return new Queue(ORDER_DESTROY_QUEUE, true);
    }

    @Bean
    public Queue orderPayDestroyQueue(){
        return new Queue(ORDER_PAY_DESTROY_QUEUE, true);
    }

    /**
     * 将queue绑定到exchange交换机
     */

    @Bean
    public Binding orderInitBinding(@Qualifier("orderInitQueue") Queue queue,
                                    @Qualifier("exchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ORDER_INIT_ROUTER_KEY).noargs();
    }

    @Bean
    public Binding orderInitDeadBinding(@Qualifier("orderInitDeadQueue") Queue queue,
                                    @Qualifier("deadExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ORDER_INIT_DEAD_ROUTER_KEY).noargs();
    }

    @Bean
    public Binding orderCommitBinding(@Qualifier("orderCommitQueue") Queue queue,
                                    @Qualifier("exchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ORDER_COMMIT_ROUTER_KEY).noargs();
    }

    @Bean
    public Binding orderCommitDeadBinding(@Qualifier("orderCommitDeadQueue") Queue queue,
                                    @Qualifier("deadExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ORDER_COMMIT_DEAD_ROUTER_KEY).noargs();
    }

    @Bean
    public Binding orderDestroyBinding(@Qualifier("orderDestroyQueue") Queue queue,
                                       @Qualifier("delayExchange") CustomExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ORDER_DESTROY_ROUTER_KEY).noargs();
    }

    @Bean
    public Binding orderPayDestroyBinding(@Qualifier("orderPayDestroyQueue") Queue queue,
                                       @Qualifier("delayExchange") CustomExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ORDER_PAY_DESTROY_ROUTER_KEY).noargs();
    }
}
