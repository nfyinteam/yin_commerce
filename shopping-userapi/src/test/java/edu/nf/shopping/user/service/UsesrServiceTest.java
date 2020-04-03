package edu.nf.shopping.user.service;

import edu.nf.shopping.user.entity.UserFace;
import edu.nf.shopping.user.entity.UserInfo;
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
    @Autowired
    private UserInfoService userInfoService;

    @Test
    void userLoginByPhone(){
        UserInfo userInfo=new UserInfo();
        userInfo.setTel("13727074222");
        userInfo.setPassword("qq520340");
        UserInfo user=service.userLoginByPhone(userInfo);
        System.out.println(user);

    }

    @Test
    void userLoginByEmail(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserEmail("a291774405@vip.qq.com");
        userInfo.setPassword("qq520340");
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

    @Test
    void updateUserInfoTest(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId("13763104156");
        userInfo.setTel("13712345678");
        userInfo.setUserName("罗大大");
        userInfo.setUserEmail("2577790234@qq.com");
        userInfo.setCarNumber("430481200004162346");
        userInfo.setSex("女");
        userInfo.setRealName("罗大大");
        UserFace userFace=new UserFace();
        userFace.setFaceId("4005");
        userInfo.setFace(userFace);
        /*userInfoService.updateUserInfo(userInfo);*/
    }
}
