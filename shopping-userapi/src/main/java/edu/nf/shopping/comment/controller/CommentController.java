package edu.nf.shopping.comment.controller;

import com.github.pagehelper.PageInfo;
import edu.nf.shopping.comment.entity.Comment;
import edu.nf.shopping.comment.service.CommentService;
import edu.nf.shopping.util.FileNameUtils;
import edu.nf.shopping.util.UploadAddressUtils;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private RestTemplate rest;

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("/list_buyShow")
    @ApiOperation(value = "查询买家秀", notes = "查询单个商品的买家秀",
            httpMethod = "get")
    private ResponseVO<PageInfo<Comment>> listBuyShow(Integer pageNum, Integer pageSize, Integer replySize, String goodsId, String dateTime, String order,String commentType,HttpServletRequest request) throws ParseException {
        PageInfo<Comment> pageInfo=commentService.listBuyShow(pageNum,pageSize,replySize,goodsId,"1578412684666",sdf.parse(dateTime),order,commentType);
        return success(pageInfo);
    }

    @RequestMapping("/list_comment")
    @ApiOperation(value = "查询回复评论", notes = "查询买家秀的回复评论",
            httpMethod = "get")
    private ResponseVO<PageInfo<Comment>> ListComment(Integer pageNum,Integer pageSize,String commentId, String dateTime, String order,HttpServletRequest request) throws ParseException {
        PageInfo<Comment> pageInfo=commentService.listComment(pageNum,pageSize,commentId,"1578412684666",sdf.parse(dateTime),order);
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

    @RequestMapping(value="add_buyShow",headers = "content-type=multipart/*")
    @ApiOperation(value = "提交商品评价", notes = "用户提交买家秀",
            httpMethod = "post")
    private ResponseVO addBuyShow(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) throws IOException {
        for (MultipartFile imageFile : files) {
            String name=FileNameUtils.newFileName(imageFile.getOriginalFilename());
            System.out.println(name);
            //FileNameUtils.upload(UploadAddressUtils.COMMENT_IMAGES,imageFile.getInputStream(),name);
        }
        return success(200,"提交评价成功");
    }
}