package edu.nf.shopping.user.dao;

import edu.nf.shopping.user.entity.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author re
 * @date 2020/3/22
 */

@Repository("userinfodao")
public interface UserinfoDao {
    /**
     * 全部用户信息
     */
    List<UserInfo> listUser();
    /**
     * 用户登录
     */
    UserInfo login(UserInfo user);
    /**
     * 查看个人信息
     */
    UserInfo selectUser(String uid);
}
