package edu.nf.shopping.user.service;

import edu.nf.shopping.user.entity.UserInfo;
import org.elasticsearch.client.security.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Vera
 * @date 2020/4/2
 */
@SpringBootTest
public class UsesrServiceTest {

    @Autowired
    private UserService service;

    @Test
    void userLoginByPhone(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserTel("13727074222");
        userInfo.setUserPassword("qq520340");
        UserInfo user=service.userLoginByPhone(userInfo);
        System.out.println(user);

    }

    @Test
    void userLoginByEmail(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserEmail("a291774405@vip.qq.com");
        userInfo.setUserPassword("qq520340");
        UserInfo user=service.userLoginByEmail(userInfo);
        System.out.println(user);
    }

    @Test
    void addUserByPhone(){
        /*UserInfo userInfo=new UserInfo();
        userInfo.setUid("13763104156");
        userInfo.setUserTel("13763104156");
        userInfo.setUserPassword("123456");
        userInfo.setUserName("Vera");
        service.addUserByPhone(userInfo);*/
    }


    @Test
    void addUserByEmail(){
        /*UserInfo userInfo=new UserInfo();
        userInfo.setUid("2186710485");
        userInfo.setUserEmail("2186710485@qq.com");
        userInfo.setUserPassword("123456");
        userInfo.setUserName("Lucy");
        service.addUserByEmail(userInfo);*/
    }

}
