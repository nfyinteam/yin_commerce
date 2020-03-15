package edu.nf.shopping.comment.dao;

import edu.nf.shopping.comment.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/12
 */
public interface CommentDao {

    /**
     * 查询某个商品的买家秀
    **/
    List<Comment> listBuyShow(@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSie,String goodsId,String order);
    /**
     * 查询某个商品的回复评论
     **/
    List<Comment> listByComment(@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSie,List<Comment> list,String comId);
    /**
     * 添加评论
     **/
    void addComment(Comment comment);

}