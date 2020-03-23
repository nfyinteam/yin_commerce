package edu.nf.shopping.comment.dao;

import edu.nf.shopping.comment.entity.CommentImage;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/23
 */
public interface ComImageDao {
    //List<CommentImage> listCommentImage(String comId);

    void addCommentImage(CommentImage commentImage);
}