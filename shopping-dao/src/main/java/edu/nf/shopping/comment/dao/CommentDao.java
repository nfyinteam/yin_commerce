package edu.nf.shopping.comment.dao;

import edu.nf.shopping.comment.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/12
 */
public interface CommentDao {

    /**
     * 查询某个商品的买家秀
    **/
    List<Comment> listBuyShow(@Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSie, String goodsId, String userId, Date dataTime, String order,String commentType);
    /**
     * 查询某个商品的回复评论
     **/
    List<Comment> listByComment(@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSie,String comId,String userId, Date dataTime, String order);
    /**
     * 查找某条评论
     **/
    Comment findComment(String comId,String goodsId,String userId);
    /**
     * 添加评论
     **/
    void addComment(Comment comment);

    void updateComment(String comId,String state);

    void deleteComment(Comment comment);
}