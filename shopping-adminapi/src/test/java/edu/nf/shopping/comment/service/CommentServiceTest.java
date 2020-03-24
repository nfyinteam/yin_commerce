package edu.nf.shopping.comment.service;

import edu.nf.shopping.comment.entity.Comment;
import edu.nf.shopping.comment.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/12
 */
@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Test
    void listComment(){
        /*List<Comment> list=commentService.listComment();
        for (Comment comments : list) {
            System.out.println(comments);
        }*/
    }
}