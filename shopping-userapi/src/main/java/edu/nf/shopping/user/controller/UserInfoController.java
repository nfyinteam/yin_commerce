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

    @PostMapping("/user/login")
    @ApiOperation(value = "用户登录", notes = "用户的登录请求",
            httpMethod = "post")
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    public ResponseVO userLogin(String userId,String passWord, HttpServletRequest request) {
        UserInfo  userInfo=service.userLogin(userId,passWord);
        if(userInfo!=null){
            request.getSession().setAttribute("userId",userInfo.getUid());
            System.out.println(request.getSession().getId());
        }
        return success(200,"登录成功！");
    }

    @RequestMapping("/get_userInfo")
    @ApiOperation(value = "获取用户信息", notes = "用户获取自己的信息",
            httpMethod = "get")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVO getUserInfo(HttpServletRequest request) {
        System.out.println("22"+request.getSession().getId());
        UserInfo  userInfo=service.getUserInfo(String.valueOf(request.getSession().getAttribute("userId")));
        return success(userInfo);
    }

}
