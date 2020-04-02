package edu.nf.shopping.comment.service;

import com.github.pagehelper.PageInfo;
import edu.nf.shopping.comment.entity.Comment;
//import edu.nf.shopping.message.ProducerServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Date;

/**
 * @author Bull fighters
 * @date 2020/3/12
 */
@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

//    @Autowired
//    private ProducerServer producerServer;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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