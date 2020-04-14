package edu.nf.shopping.comment.service;

import com.github.pagehelper.PageInfo;
import edu.nf.shopping.comment.entity.Comment;
import edu.nf.shopping.message.entity.Notice;
import edu.nf.shopping.message.service.NoticeService;
import edu.nf.shopping.page.entity.PageRegion;
import edu.nf.shopping.util.LettuceUtils;
import io.lettuce.core.api.sync.RedisCommands;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Date;
import java.util.List;

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

    @Test
    void testNotice(){
        RedisCommands<String, String> commands = LettuceUtils.getCommands();
        List<PageRegion> list=(List<PageRegion>)redisTemplate.opsForValue().get("pageCache::pageRegion-0");
        if(list != null){
            for (PageRegion pageRegion : list) {
                System.out.println(pageRegion);
            }
        }
    }
}