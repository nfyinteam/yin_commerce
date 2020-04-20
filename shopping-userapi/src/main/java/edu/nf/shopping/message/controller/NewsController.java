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
import javax.servlet.http.HttpSession;
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
    @ApiOperation(value = "查询聊天记录", notes = "用户根据订单号查询与指定客服的聊天记录",
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

    @RequestMapping("/get/whisper/{pageStart}/{pageSize}")
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
                                    HttpServletRequest request){
        UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
        List<News> list=newsService.listUserNews(pageStart,pageSize,userInfo.getUserId(),null,"NULL");
        return success(list);
    }

    @RequestMapping(value = "/post/whisper")
    @ApiOperation(value = "添加聊天消息", notes = "用户发送聊天消息则添加到数据库，并发送给接收方",
            httpMethod = "post")
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    private ResponseVO addChatNews(News news, HttpSession session){
        UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
        news.setAuthorId(userInfo.getUserId());
        news.setUserFace(userInfo.getFace().getFaceFile());
        News n=newsService.addNews(null,news,news.getReceiveUserId(),userInfo.getUserId(),"admin.chat.news.message");
        return success(n);
    }

    @RequestMapping(value = "/post/whisper/image",headers = "content-type=multipart/*")
    @ApiOperation(value = "添加聊天图片", notes = "用户发送聊天图片则添加到数据库，并发送给接收方",
            httpMethod = "post")
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    private ResponseVO addChatImageNews(@RequestParam("imageFile") MultipartFile file,News news, HttpSession session){
        UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
        news.setAuthorId(userInfo.getUserId());
        news.setUserFace(userInfo.getFace().getFaceFile());
        News n=newsService.addNews(file,news,news.getReceiveUserId(),userInfo.getUserId(),"admin.chat.news.message");
        return success(n);
    }

    @RequestMapping(value = "/patch/news/newsId")
    @ApiOperation(value = "修改消息状态", notes = "根据消息编号修改聊天消息为已读",
            httpMethod = "post")
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    private ResponseVO updateNewsState(String authorId,String orderId, HttpSession session){
        UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
        System.out.println(authorId+"/"+orderId);
        newsService.updateNewsState(authorId,userInfo.getUserId(),orderId);
        return success(200,"");
    }

    @RequestMapping(value = "/get/newsList/userId")
    @ApiOperation(value = "查询消息列表", notes = "根据用户编号查询该用户的客服列表",
            httpMethod = "get")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    private ResponseVO getUserNewsList(HttpSession session){
        UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
        List<UserInfo> list=newsService.getUserNewsListByUserId(userInfo.getUserId(),"0");
        return success(list);
    }
}