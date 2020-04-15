package edu.nf.shopping.message.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import edu.nf.shopping.message.entity.Notice;
import edu.nf.shopping.message.service.NoticeService;
import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.client.security.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/4/4
 */
@RestController
public class NoticeController extends BaseController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/get/notice/reply")
    @ApiOperation(value = "查询回复消息", notes = "用户查询自己的回复消息",
            httpMethod = "get")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    private ResponseVO listUserReply(HttpSession session){
        UserInfo u=(UserInfo)session.getAttribute("userInfo");
        List<Notice> list=noticeService.userListNotice("0",u.getUserId());
        return success(list);
    }

    @RequestMapping("/get/notice/love")
    @ApiOperation(value = "查询回复消息", notes = "用户查询自己的回复消息",
            httpMethod = "get")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    private ResponseVO listUserLove(HttpSession session){
        UserInfo u=(UserInfo)session.getAttribute("userInfo");
        List<Notice> list=noticeService.userListNotice("1",u.getUserId());
        return success(list);
    }

    @RequestMapping("/get/notice/system")
    @ApiOperation(value = "查询回复消息", notes = "用户查询自己的回复消息",
            httpMethod = "get")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    private ResponseVO listUserSystem(HttpSession session){
        UserInfo u=(UserInfo)session.getAttribute("userInfo");
        List<Notice> list=noticeService.userListNotice("2",u.getUserId());
        return success(list);
    }

    @RequestMapping("/newMessageNum")
    @ApiOperation(value = "查询回复消息", notes = "用户查询自己的回复消息",
            httpMethod = "get")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    private ResponseVO listNotViewByUserId(HttpSession session){
        UserInfo u=(UserInfo)session.getAttribute("userInfo");
        List<Notice> list=noticeService.listNotViewByUserId(u.getUserId());
        return success(list);
    }
}