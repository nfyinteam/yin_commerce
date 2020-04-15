package edu.nf.shopping.user.controller;

import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.user.service.UserInfoService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author re
 * @date 2020/3/22
 */
@RestController
public class UserInfoController extends BaseController {

    @Autowired
    private UserInfoService service;

    @RequestMapping("/user/login")
    @ApiOperation(value = "用户登录", notes = "用户的登录请求",
            httpMethod = "post")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVO userLogin(String userId,String passWord, HttpSession session) {
        session.setAttribute("userInfo", service.userLogin(userId,passWord));
        return success(200,"登录成功！");
    }

    @RequestMapping("/get/userInfo")
    @ApiOperation(value = "获取用户信息", notes = "用户获取自己的信息",
            httpMethod = "get")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVO getUserInfo(HttpSession session) {
        UserInfo user = (UserInfo)session.getAttribute("userInfo");
        if(user == null){
            fail(500, "请登录");
        }
        return success(user);
    }

    @RequestMapping("/user/cancellation")
    @ApiOperation(value = "注销", notes = "用户注销登录",
            httpMethod = "get")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVO cancellationUser(HttpSession session) {
        session.removeAttribute("userInfo");
        session.invalidate();
        return success(200);
    }

}
