package edu.nf.shopping.user.service;

import edu.nf.shopping.user.entity.Userinfo;
import org.springframework.security.core.userdetails.User;

import javax.security.auth.login.LoginException;
import java.util.List;

/**
 * @author re
 * @date 2020/3/22
 */
public interface UserinfoService {
    List<Userinfo> listUser() throws Exception;
    Userinfo selectUser(Userinfo userinfo) throws LoginException;
}
