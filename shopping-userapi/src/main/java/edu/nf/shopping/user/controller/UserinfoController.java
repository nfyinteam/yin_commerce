package edu.nf.shopping.user.controller;

import com.example.project.controller.vo.ResponseVO;
import com.example.project.servise.UserService;
import edu.nf.shopping.user.entity.Userinfo;
import edu.nf.shopping.user.service.UserinfoService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;

/**
 * @author re
 * @date 2020/3/22
 */
@RestController
public class UserinfoController extends BaseController {
    @Autowired
    private UserinfoService service;

    @PostMapping("user_login")
    public ResponseVO userlogin(@Valid Userinfo user) throws LoginException {
       service.selectUser(user);
        return success("login.html");
    }

}
