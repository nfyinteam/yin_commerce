package edu.nf.shopping.user.service.impl;

import com.example.project.dao.UserDao;
import com.example.project.servise.UserService;
import edu.nf.shopping.user.dao.UserinfoDao;
import edu.nf.shopping.user.entity.Userinfo;
import edu.nf.shopping.user.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.List;

/**
 * @author re
 * @date 2020/3/22
 */
@Service("userinfoService")
public class UserinfoServiceImpl implements UserinfoService {
    @Autowired
    private UserinfoDao dao;
    @Override
    public List<Userinfo> listUser() throws Exception {
        try{  List<Userinfo> list=dao.listUser();
            return list;
        } catch (Exception e) {
            throw new Exception("错误");
        }

    }

    @Override
    public Userinfo selectUser(Userinfo user) throws LoginException {
        try{
            return user;
        } catch (Exception e) {
           throw new LoginException("账号或秘密错误");
        }
    }
}
