package edu.nf.shopping.user.service;
import edu.nf.shopping.user.entity.UserInfo;

/**
 * @author Vera
 * @date 2020/4/2
 */
public interface UserService {

    /**
     * 通过手机号码登入
     * @param userInfo
     */
    UserInfo userLoginByPhone(UserInfo userInfo);

    /**
     * 通过邮箱登入
     * @param userInfo
     */
    UserInfo userLoginByEmail(UserInfo userInfo);



    /**
     * 通过手机号码注册
     * @param userInfo
     */
    void addUserByPhone(UserInfo userInfo);

    /**
     * 通过邮箱注册
     * @param userInfo
     */
    void addUserByEmail(UserInfo userInfo);
}
