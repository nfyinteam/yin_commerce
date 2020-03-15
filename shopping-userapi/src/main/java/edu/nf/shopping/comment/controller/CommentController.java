package edu.nf.shopping.comment.controller;

import com.github.pagehelper.PageInfo;
import edu.nf.shopping.comment.entity.Comment;
import edu.nf.shopping.comment.service.CommentService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/12
 */
@RestController
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/list_buyShow")
    @ApiOperation(value = "查询买家秀", notes = "查询单个商品的买家秀和子评论",
            httpMethod = "get")
    private ResponseVO<PageInfo<Comment>> listComment(Integer pageNum,Integer pageSize,String goodsId,String order){
        PageInfo<Comment> pageInfo=commentService.listBuyShow(pageNum,pageSize,goodsId,order);
        return success(pageInfo);
    }

    @RequestMapping("/add_comment")
    @ApiOperation(value = "添加评论", notes = "用户发表一个评论",
            httpMethod = "post")
    private ResponseVO addComment(@ModelAttribute Comment comment, HttpServletRequest request){
        comment.setUserId("1578412684666");
        commentService.addComment(comment);
        return success(200,"发表评论成功");
    }
}