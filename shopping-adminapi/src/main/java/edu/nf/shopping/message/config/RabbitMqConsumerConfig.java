package edu.nf.shopping.message.config;

import com.rabbitmq.client.Channel;
import edu.nf.shopping.message.config.MessageRabbitConfig;
import edu.nf.shopping.message.entity.News;
import edu.nf.shopping.message.service.NewsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Headers;

import java.io.IOException;
import java.util.Map;

/**
 * @author Bull fighters
 * @date 2020/4/15
 */
@Configuration
public class RabbitMqConsumerConfig {

    @Autowired
    private NewsService newsService;

    /**
     * 客服的聊天消息的消费者，负责处理聊天消息
     * @param news
     * @param headers
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = MessageRabbitConfig.ADMIN_CHAT_NEWS_QUEUE)
    public void userChatMessage(News news, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        System.out.println("admin接收："+news.toString());
        newsService.sendNews(news);
    }
}