package edu.nf.shopping.user.controller;

import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.user.service.UserService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author Vera
 * @date 2020/4/2
 */

@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService service;

    @PostMapping("/user/login/phone")
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    public ResponseVO userLoginByPhone(String userPhone, String password, HttpSession session){

        UserInfo userInfo=new UserInfo();
        userInfo.setUserTel(userPhone);
        userInfo.setUserPassword(password);
        UserInfo user=service.userLoginByPhone(userInfo);
        if(user!=null){
            if(user.getUserPassword().equals(password) && password!=null){
                session.setAttribute("user",user);
                return success(200);
            }
            return fail(401,"账号或密码错误！");
        }

        return fail(402,"用户不存在！");


    }


    @PostMapping("/user/login/email")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVO userLoginByEmail(String userEmail,String password,HttpSession session){
        ResponseVO vo=new ResponseVO();
        UserInfo userInfo=new UserInfo();
        userInfo.setUserEmail(userEmail);
        userInfo.setUserPassword(password);
        UserInfo user=service.userLoginByEmail(userInfo);
        if(user!=null){
            if(user.getUserPassword().equals(password) && password!=null){
                session.setAttribute("user",user);
                return success(200);
            }
            return fail(401,"账号或密码错误！");
        }

        return fail(402,"用户不存在！");
    }
}
