package edu.nf.shopping.config;

import edu.nf.shopping.comment.config.CommentRabbitConfig;
import edu.nf.shopping.goods.config.GoodsRabbitConfig;
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
@Import({OrderRabbitConfig.class, GoodsRabbitConfig.class, CommentRabbitConfig.class})
public class RabbitConfig {

    public static final String EXCHANGE_NAME = "exchange";

    public static final String MESSAGE_QUEUE = "message.queue";

    public static final String MESSAGE_ROUTER_KEY = "message.message";


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
    public Queue messageQueue(){
        return new Queue(MESSAGE_QUEUE, true);
    }


    /**
     * 将queue绑定到exchange
     */

    @Bean
    public Binding messageBinding(@Qualifier("messageQueue") Queue queue,
                                  @Qualifier("exchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(MESSAGE_ROUTER_KEY).noargs();
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