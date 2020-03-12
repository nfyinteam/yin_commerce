package edu.nf.shopping.comment.service.impl;

import edu.nf.shopping.comment.dao.CommentDao;
import edu.nf.shopping.comment.entity.Comment;
import edu.nf.shopping.comment.exception.CommentException;
import edu.nf.shopping.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/12
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> listComment() {
        try{
            return commentDao.listComment();
        }catch (RuntimeException e){
            throw new CommentException(e.getMessage());
        }

    }
}