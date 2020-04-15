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

    public static final String USER_CHAT_NEWS_QUEUE = "user.chat.news.queue";
    public static final String ADMIN_CHAT_NEWS_QUEUE = "admin.chat.news.queue";
    public static final String NOTICE_QUEUE = "notice.queue";

    public static final String USER_CHAT_NEWS_ROUTER_KEY = "user.chat.news.message";
    public static final String ADMIN_CHAT_NEWS_ROUTER_KEY = "admin.chat.news.message";
    public static final String NOTICE_ROUTER_KEY = "notice.message";

    @Bean
    public Queue userChatNewsQueue(){
        return new Queue(USER_CHAT_NEWS_QUEUE, true);
    }

    @Bean
    public Binding userChatNewsBinding(@Qualifier("userChatNewsQueue") Queue queue,
                                 @Qualifier("directExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(USER_CHAT_NEWS_ROUTER_KEY).noargs();
    }

    @Bean
    public Queue adminChatNewsQueue(){
        return new Queue(ADMIN_CHAT_NEWS_QUEUE, true);
    }

    @Bean
    public Binding adminChatNewsBinding(@Qualifier("adminChatNewsQueue") Queue queue,
                                   @Qualifier("directExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ADMIN_CHAT_NEWS_ROUTER_KEY).noargs();
    }
}