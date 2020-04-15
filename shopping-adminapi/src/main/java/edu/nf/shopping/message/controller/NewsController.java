package edu.nf.shopping.message.controller;

import com.rabbitmq.client.Channel;
import edu.nf.shopping.message.config.MessageRabbitConfig;
import edu.nf.shopping.message.entity.News;
import edu.nf.shopping.message.service.NewsService;
import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
        List<News> list=newsService.listUserNews(pageStart,pageSize,userInfo.getUserId(),null,orderId);
        return success(list);
    }

    @RequestMapping("/get/whisper/authorId/{authorId}/{pageStart}/{pageSize}")
    @ApiOperation(value = "查询聊天记录", notes = "用户查询与临时客服的聊天记录",
            httpMethod = "get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageStart", value = "页数", required = true),
            @ApiImplicitParam(name = "pageSize", value = "条目数", required = true),
            @ApiImplicitParam(name = "authorId", value = "发送者编号")
    })
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    private ResponseVO listUserChatNews(@PathVariable("pageStart") Integer pageStart,
                                        @PathVariable("pageSize") Integer pageSize,
                                        @PathVariable("authorId") String authorId,
                                        HttpServletRequest request){
        UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
        List<News> list=newsService.listUserNews(pageStart,pageSize,userInfo.getUserId(),authorId,"NULL");
        return success(list);
    }

    @RequestMapping(value = "/post/whisper")
    @ApiOperation(value = "添加聊天消息", notes = "发送聊天消息则添加到数据库，并发送给接收方",
            httpMethod = "post")
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    private ResponseVO addChatNews(News news, HttpServletRequest request){
        UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
        news.setAuthorId(userInfo.getUserId());
        News n=newsService.addNews(null,news,userInfo.getUserId(),news.getReceiveUserId(),"user.chat.news.message");
        return success(n);
    }

    @RequestMapping(value = "/post/whisper/image",headers = "content-type=multipart/*")
    @ApiOperation(value = "添加聊天图片", notes = "用户发送聊天图片则添加到数据库，并发送给接收方",
            httpMethod = "post")
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    private ResponseVO addChatImageNews(@RequestParam("imageFile") MultipartFile file,News news, HttpServletRequest request){
        UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
        news.setAuthorId(userInfo.getUserId());
        News n=newsService.addNews(file,news,userInfo.getUserId(),news.getReceiveUserId(),"user.chat.news.message");
        return success(n);
    }

    @RequestMapping(value = "/patch/news/newsId")
    @ApiOperation(value = "修改消息状态", notes = "根据消息编号修改聊天消息为已读",
            httpMethod = "post")
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    private ResponseVO updateNewsState(String authorId,String orderId, HttpServletRequest request){
        System.out.println(authorId+"/"+orderId);
        UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
        newsService.updateNewsState(authorId,userInfo.getUserId(),orderId);
        return success(200,"");
    }

    @RequestMapping(value = "/get/singleNotView/userId")
    @ApiOperation(value = "查询未读消息数", notes = "临时用户的未读消息数",
            httpMethod = "get")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    private ResponseVO findSingleNotView(HttpServletRequest request){
        UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
        List<News> list=newsService.findSingleNotView(userInfo.getUserId());
        return success(list);
    }

    @RequestMapping(value = "/get/newsList/userId")
    @ApiOperation(value = "查询消息列表", notes = "根据客服编号查询该客服的用户列表",
            httpMethod = "get")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    private ResponseVO getUserNewsList(HttpServletRequest request){
        UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
        List<UserInfo> list=newsService.getUserNewsListByUserId(userInfo.getUserId(),"1");
        return success(list);
    }
}