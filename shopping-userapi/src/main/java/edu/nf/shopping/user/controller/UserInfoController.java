package edu.nf.shopping.user.controller;
import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.user.service.UserInfoService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
    public ResponseVO userLogin(String userId,String passWord, HttpServletRequest request) {
        service.userLogin(userId,passWord);
        request.getSession().setAttribute("userId",userId);
        return success(200,"登录成功！");
    }

    @RequestMapping("/get_userInfo")
    @ApiOperation(value = "获取用户信息", notes = "用户获取自己的信息",
            httpMethod = "get")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVO getUserInfo(HttpServletRequest request) {
        String userId=String.valueOf(request.getSession().getAttribute("userId"));
        UserInfo userInfo=service.getUserInfo(userId);
        return success(userInfo);
    }

    @RequestMapping("/cancellation/user")
    @ApiOperation(value = "注销", notes = "用户注销登录",
            httpMethod = "get")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVO cancellationUser(HttpServletRequest request) {
        request.getSession().removeAttribute("userId");
        request.getSession().invalidate();
        return success(200);
    }

}
