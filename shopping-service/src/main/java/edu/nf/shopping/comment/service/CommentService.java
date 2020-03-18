package edu.nf.shopping.comment.service;

import com.github.pagehelper.PageInfo;
import edu.nf.shopping.comment.entity.Comment;

import java.util.Date;
import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/12
 */
public interface CommentService {

    /**
     * 查询某个商品的买家秀
     **/
    PageInfo<Comment> listBuyShow(Integer pageNum, Integer pageSize, Integer replySize, String goodsId, String userId, Date dataTime, String order);
    /**
     * 查询某个买家秀的回评
     **/
    PageInfo<Comment> listComment(Integer pageNum, Integer pageSize, String comId,String userId, Date dataTime, String order);
    /**
     * 查找某条评论
     **/
    Comment findComment(String comId,String goodsId);
    /**
     * 添加评论
     **/
    void addComment(Comment comment);
    /**
     *
     **/
    void updateComment(Comment comment);

    void deleteComment(Comment comment);
}