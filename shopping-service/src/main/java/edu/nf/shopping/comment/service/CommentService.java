package edu.nf.shopping.comment.service;

import com.github.pagehelper.PageInfo;
import edu.nf.shopping.comment.entity.Comment;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/12
 */
public interface CommentService {

    /**
     * 查询某个商品的买家秀
     **/
    PageInfo<Comment> listBuyShow(Integer pageNum, Integer pageSize, String goodsId, String order);

}