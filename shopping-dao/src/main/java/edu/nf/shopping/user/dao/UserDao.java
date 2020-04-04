package edu.nf.shopping.user.dao;
import edu.nf.shopping.user.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author Vera
 * @date 2020/4/1
 */
public interface UserDao {

    /**
     * 通过手机号码登入
     * @param user
     */
    UserInfo userLoginByPhone(@Param("user") UserInfo user);

    /**
     * 通过邮箱登入
     * @param user
     */
    UserInfo userLoginByEmail(@Param("user") UserInfo user);

    /**
     * 退出账号
     */
//    void userLogout();

    /**
     * 通过手机号码注册
     * @param userInfo
     */
    void addUserByPhone(@Param("userInfo") UserInfo userInfo);

    /**
     * 通过邮箱注册
     * @param userInfo
     */
    void addUserByEmail(@Param("userInfo") UserInfo userInfo);




}
