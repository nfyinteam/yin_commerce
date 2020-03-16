package edu.nf.shopping.comment.service;

import com.github.pagehelper.PageInfo;
import edu.nf.shopping.comment.entity.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Bull fighters
 * @date 2020/3/12
 */
@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ProducerServer producerServer;

    @Test
    void listComment(){
        PageInfo<Comment> list=commentService.listComment(2,6,"1001");
        for (Comment comment : list.getList()) {
            System.out.println(comment);
        }
    }

    @Test
    void rabbitTest(){
        PageInfo<Comment> list=commentService.listBuyShow(1,1,3,"1578412684903","");
        producerServer.sendMessage(list,1);
    }
}