package edu.nf.shopping.comment.service;

import com.github.pagehelper.PageInfo;
import com.rabbitmq.client.Channel;
import edu.nf.shopping.comment.config.CommentRabbitConfig;
import edu.nf.shopping.comment.entity.Comment;
import edu.nf.shopping.config.RabbitConfig;
import edu.nf.shopping.message.config.MessageRabbitConfig;
import edu.nf.shopping.message.entity.News;
import edu.nf.shopping.message.entity.Notice;
import edu.nf.shopping.message.service.NoticeService;
import edu.nf.shopping.page.entity.PageRegion;
import edu.nf.shopping.util.LettuceUtils;
import edu.nf.shopping.util.UUIDUtils;
import io.lettuce.core.api.sync.RedisCommands;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.handler.annotation.Headers;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Bull fighters
 * @date 2020/3/12
 */
@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void rabbitTest(){
        PageInfo<Comment> list=commentService.listComment(1,10,"1001","1578412684666",new Date(),"1");
        for (Comment comment : list.getList()) {
            System.out.println(comment);
        }
    }

    @Test
    void testForValue() {
        //添加
        stringRedisTemplate.opsForValue().set("user:1001", "user1");
        //依据key获取value
        String name = stringRedisTemplate.opsForValue().get("user:1001");
        System.out.println(name);
        //删除
        stringRedisTemplate.delete("user:1001");
    }

}