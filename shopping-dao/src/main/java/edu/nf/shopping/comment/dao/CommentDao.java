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
     * 用户查询某个商品的买家秀
    **/
    List<Comment> listBuyShow(@Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSie, String goodsId, String userId, Date dataTime, String order,String commentType);
    /**
     * 用户查询某个买家秀的回复评论
     **/
    List<Comment> listByComment(@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSie,String comId,String userId, Date dataTime, String order);
    /**
     * 查找某条评论
     **/
    Comment findComment(String comId,String goodsId,String userId);

    /**
     *查询待审核的买家秀
     */
    List<Comment> listStayToExamineBuyShow(@Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    /**
     *查询被举报的评论
     */
    List<Comment> listReportComment(@Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize,String type);

    /**
     * 添加评论
     **/
    void addComment(Comment comment);

    /**
     * 修改评论状态
     * @param comId
     * @param state
     */
    int updateComment(String comId,String state);

    void deleteComment(Comment comment);
}