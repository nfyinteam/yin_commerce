package edu.nf.shopping.user.service;

import edu.nf.shopping.user.entity.UserInfo;
import javax.security.auth.login.LoginException;
import java.util.List;

/**
 * @author re
 * @date 2020/3/22
 */
public interface UserinfoService {
    List<UserInfo> listUser() throws Exception;
    UserInfo selectUser(UserInfo userinfo) throws LoginException;
}
