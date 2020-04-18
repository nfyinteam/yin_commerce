package edu.nf.shopping.config;

import edu.nf.shopping.comment.config.CommentRabbitConfig;
import edu.nf.shopping.goods.config.GoodsRabbitConfig;
import edu.nf.shopping.message.config.MessageRabbitConfig;
import edu.nf.shopping.order.config.OrderRabbitConfig;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bull fighters
 * @date 2020/3/14
 */
@Configuration
@Import({OrderRabbitConfig.class, GoodsRabbitConfig.class,
        CommentRabbitConfig.class, MessageRabbitConfig.class})
public class RabbitConfig {

    public static final String EXCHANGE_NAME = "direct.exchange";
    public static final String DELAY_EXCHANGE_NAME = "delay.exchange";
    public static final String DEAD_EXCHANGE_NAME = "dead.exchange";

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
     * 自定义死信交换机
     * @return
     */
    @Bean
    public CustomExchange deadExchange() {
        Map<String, Object> params = new HashMap<>();
        params.put(" x-dead-letter-exchange","dlx.exchange");
        return new CustomExchange(DEAD_EXCHANGE_NAME, "direct", true, false, params);
    }

    /**
     * 自定义延迟交换机
     * @return
     */
    @Bean
    public CustomExchange delayExchange() {
        Map<String, Object> params = new HashMap<>();
        params.put("x-delayed-type", "direct");
        return new CustomExchange(DELAY_EXCHANGE_NAME, "x-delayed-message", true, false, params);
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