package edu.nf.shopping.comment.dao;

import edu.nf.shopping.comment.entity.Comment;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/12
 */
public interface CommentDao {

    /**
     * 查询所有评论
    **/
    List<Comment> listComment();
}