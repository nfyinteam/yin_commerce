package edu.nf.shopping.comment.controller;

import com.github.pagehelper.PageInfo;
import edu.nf.shopping.comment.entity.Comment;
import edu.nf.shopping.comment.service.CommentService;
import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.client.security.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Bull fighters
 * @date 2020/3/12
 */
@RestController
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("get/buyShow/{pageNum}/{pageSize}/{replySize}/{goodsId}/{refreshTime}/{order}/{commentType}")
    @ApiOperation(value = "查询买家秀", notes = "查询单个商品的买家秀",
            httpMethod = "get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(name = "pageSize", value = "条目数", required = true),
            @ApiImplicitParam(name = "replySize", value = "回复评论数量", required = true),
            @ApiImplicitParam(name = "goodsId", value = "商品编号", required = true),
            @ApiImplicitParam(name = "refreshTime", value = "刷新页面时间", required = true),
            @ApiImplicitParam(name = "order", value = "排序规则"),
            @ApiImplicitParam(name = "commentType", value = "评论类型")
    })
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    private ResponseVO<PageInfo<Comment>> listBuyShow(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, @PathVariable("replySize") Integer replySize, @PathVariable("goodsId") String goodsId, @PathVariable("refreshTime") String refreshTime, @PathVariable("order") String order, @PathVariable("commentType") String commentType,
                                                      HttpServletRequest request) throws ParseException {
        UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
        String userId=userInfo!=null?userInfo.getUserId():"";
        PageInfo<Comment> pageInfo=commentService.listBuyShow(pageNum,pageSize,replySize,goodsId,userId,sdf.parse(refreshTime),order,commentType);
        return success(pageInfo);
    }

    @RequestMapping("get/comment/{pageNum}/{pageSize}/{commentId}/{refreshTime}/{order}")
    @ApiOperation(value = "查询回复评论", notes = "查询买家秀的回复评论",
            httpMethod = "get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(name = "pageSize", value = "条目数", required = true),
            @ApiImplicitParam(name = "commentId", value = "父级评论编号", required = true),
            @ApiImplicitParam(name = "refreshTime", value = "刷新页面时间", required = true),
            @ApiImplicitParam(name = "order", value = "排序规则"),
    })
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    private ResponseVO<PageInfo<Comment>> listComment(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, @PathVariable("commentId") String commentId, @PathVariable("refreshTime") String refreshTime, @PathVariable("order") String order,
                                                      HttpSession session) throws ParseException {
        UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
        String userId=userInfo!=null?userInfo.getUserId():"";
        PageInfo<Comment> pageInfo=commentService.listComment(pageNum,pageSize,commentId,userId,sdf.parse(refreshTime),order);
        return success(pageInfo);
    }

    @RequestMapping("post/comment")
    @ApiOperation(value = "添加评论", notes = "用户发表一个评论",
            httpMethod = "post")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    private ResponseVO addComment(@ModelAttribute Comment comment, HttpServletRequest request){
        UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
        comment.setUserId(userInfo.getUserId());
        commentService.addComment(comment);
        return success(200,"发表评论成功");
    }

    @RequestMapping(value="post/buyShow",headers = "content-type=multipart/*")
    @ApiOperation(value = "提交商品评价", notes = "用户提交买家秀",
            httpMethod = "post")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    private ResponseVO addBuyShow(@RequestParam("imageFile")MultipartFile[] files,Comment comment,HttpServletRequest request) throws IOException {
        UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
        comment.setUserId(userInfo.getUserId());
        commentService.addBuyShow(files,comment);
        return success(200,"提交评价成功");
    }

    @RequestMapping("/delete/comment/id")
    @ApiOperation(value = "删除评论", notes = "用户删除自己的评论",
            httpMethod = "post")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    private ResponseVO deleteComment(String comId, HttpServletRequest request){
        UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
        commentService.updateCommentState(comId,"2",userInfo.getUserId());
        return success(200,"删除成功");
    }

}