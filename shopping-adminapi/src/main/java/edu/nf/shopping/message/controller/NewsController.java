package edu.nf.shopping.message.controller;

import edu.nf.shopping.message.entity.News;
import edu.nf.shopping.message.service.NewsService;
import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/4/6
 */
@RestController
public class NewsController extends BaseController{

    @Autowired
    private NewsService newsService;

    @RequestMapping("/get/whisper/orderId/{orderId}/{pageStart}/{pageSize}")
    @ApiOperation(value = "查询聊天记录", notes = "根据订单查询与客户的聊天记录",
            httpMethod = "get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "order", value = "订单编号"),
            @ApiImplicitParam(name = "pageStart", value = "页数", required = true),
            @ApiImplicitParam(name = "pageSize", value = "条目数", required = true)
    })
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    private ResponseVO listUserNewsByOrder(@PathVariable("orderId") String orderId,
                                    @PathVariable("pageStart") Integer pageStart,
                                    @PathVariable("pageSize") Integer pageSize,
                                    HttpServletRequest request){
        UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
        List<News> list=newsService.listUserNews(pageStart,pageSize,userInfo.getUserId(),orderId);
        return success(list);
    }

    @RequestMapping(value = "/post/whisper")
    @ApiOperation(value = "添加聊天消息", notes = "发送聊天消息则添加到数据库，并发送给接收的用户",
            httpMethod = "post")
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    private ResponseVO addChatNews(News news, HttpServletRequest request){
        UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
        news.setAuthorId(userInfo.getUserId());
        News n=newsService.addNews(null,news,userInfo.getUserId(),news.getReceiveUserId());
        return success(n);
    }

    @RequestMapping(value = "/post/whisper/image",headers = "content-type=multipart/*")
    @ApiOperation(value = "添加聊天图片", notes = "用户发送聊天图片则添加到数据库，并发送给接收的用户",
            httpMethod = "post")
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    private ResponseVO addChatImageNews(@RequestParam("imageFile") MultipartFile file,News news, HttpServletRequest request){
        UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
        news.setAuthorId(userInfo.getUserId());
        News n=newsService.addNews(file,news,userInfo.getUserId(),news.getReceiveUserId());
        return success(n);
    }

    @RequestMapping(value = "/patch/news/newsId")
    @ApiOperation(value = "修改消息状态", notes = "根据消息编号修改聊天消息为已读",
            httpMethod = "post")
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    private ResponseVO updateNewsState(String newsId,String orderId, HttpServletRequest request){
        System.out.println(newsId+"/"+orderId);
        UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
        newsService.updateNewsState(newsId,orderId,userInfo.getUserId());
        return success(200,"");
    }

    @RequestMapping(value = "/get/newsList/userId")
    @ApiOperation(value = "查询消息列表", notes = "根据用户编号查询该用户的客服列表",
            httpMethod = "post")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    private ResponseVO getUserNewsList(HttpServletRequest request){
        UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
        List<UserInfo> list=newsService.getUserNewsListByUserId(userInfo.getUserId(),"1");
        return success(list);
    }
}