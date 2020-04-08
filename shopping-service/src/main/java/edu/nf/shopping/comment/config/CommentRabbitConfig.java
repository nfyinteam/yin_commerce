package edu.nf.shopping.comment.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Bull fighters
 * @date 2020/4/8
 */
@Configuration
public class CommentRabbitConfig {
    public static final String PRAISE_QUEUE = "praise.queue";
    public static final String COMMENT_QUEUE = "comment.queue";

    public static final String PRAISE_ROUTER_KEY = "praise.message";
    public static final String COMMENT_ROUTER_KEY = "comment.message";

    @Bean
    public Queue praiseQueue(){
        return new Queue(PRAISE_QUEUE, true);
    }

    @Bean
    public Queue commentQueue(){
        return new Queue(COMMENT_QUEUE, true);
    }


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

}