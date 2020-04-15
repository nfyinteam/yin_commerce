package edu.nf.shopping.comment.config;

import edu.nf.shopping.config.RabbitConfig;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bull fighters
 * @date 2020/4/8
 */
@Configuration
public class CommentRabbitConfig {
    public static final String PRAISE_QUEUE = "praise.queue";
    public static final String PRAISE_DEAD_QUEUE = "praise.dead.queue";
    public static final String COMMENT_QUEUE = "comment.queue";
    public static final String COMMENT_DEAD_QUEUE = "comment.dead.queue";

    public static final String PRAISE_ROUTER_KEY = "praise.message";
    public static final String PRAISE_DEAD_ROUTER_KEY = "praise.dead.message";
    public static final String COMMENT_ROUTER_KEY = "comment.message";
    public static final String COMMENT_DEAD_ROUTER_KEY = "comment.dead.message";

    @Bean
    public Queue praiseQueue(){
        Map<String, Object> args = new HashMap<>(2);
        //这里声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", RabbitConfig.DEAD_EXCHANGE_NAME);
        //这里声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", PRAISE_DEAD_ROUTER_KEY);
        return QueueBuilder.durable(PRAISE_QUEUE).withArguments(args).build();

    }

    @Bean
    public Queue praiseDeadQueue(){
        return new Queue(PRAISE_DEAD_QUEUE, true);
    }

    @Bean
    public Queue commentQueue(){
        Map<String, Object> args = new HashMap<>(2);
        //这里声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", RabbitConfig.DEAD_EXCHANGE_NAME);
        //这里声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", COMMENT_DEAD_ROUTER_KEY);
        return QueueBuilder.durable(COMMENT_QUEUE).withArguments(args).build();

    }

    @Bean
    public Queue commentDeadQueue(){
        return new Queue(COMMENT_DEAD_QUEUE, true);
    }

    @Bean
    public Binding praiseBinding(@Qualifier("praiseQueue") Queue queue,
                                 @Qualifier("directExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(PRAISE_ROUTER_KEY).noargs();
    }

    @Bean
    public Binding praiseDeadBinding(@Qualifier("praiseDeadQueue") Queue queue,
                                      @Qualifier("deadExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(PRAISE_DEAD_ROUTER_KEY).noargs();
    }

    @Bean
    public Binding commentBinding(@Qualifier("commentQueue") Queue queue,
                                  @Qualifier("directExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(COMMENT_ROUTER_KEY).noargs();
    }

    @Bean
    public Binding commentDeadBinding(@Qualifier("commentDeadQueue") Queue queue,
                                      @Qualifier("deadExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(COMMENT_DEAD_ROUTER_KEY).noargs();
    }

}