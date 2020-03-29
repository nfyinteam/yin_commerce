package edu.nf.shopping.user.dao;

import edu.nf.shopping.user.entity.UserInfo;

import java.util.List;

/**
 * @author re
 * @date 2020/3/22
 */

public interface UserInfoDao {
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
