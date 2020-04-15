package edu.nf.shopping.message.config;

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
public class MessageRabbitConfig {

    public static final String CHAT_NEWS_QUEUE = "chat.news.queue";
    public static final String NOTICE_QUEUE = "notice.queue";

    public static final String CHAT_NEWS_ROUTER_KEY = "chat.news.message";
    public static final String NOTICE_ROUTER_KEY = "notice.message";

    @Bean
    public Queue chatNewsQueue(){
        return new Queue(CHAT_NEWS_QUEUE, true);
    }

    @Bean
    public Binding chatNewsBinding(@Qualifier("chatNewsQueue") Queue queue,
                                 @Qualifier("directExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(CHAT_NEWS_ROUTER_KEY).noargs();
    }
}