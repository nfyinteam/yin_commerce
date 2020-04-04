package edu.nf.shopping.user.service;

import edu.nf.shopping.warehouse.entity.City;
import edu.nf.shopping.user.entity.UserAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Vera
 * @date 2020/4/3
 */
@SpringBootTest
public class UserAddressServiceTest {

    @Autowired
    private UserAddressService service;

    @Test
    void listUserAddressTest(){
        List<UserAddress> list=service.listUserAddress("1578412688888");
        for(UserAddress user:list){
            System.out.println(user.getAddressId());
            System.out.println(user.getAddressName());
            System.out.println(user.getAddressTel());
            System.out.println(user.getAddressUser());
            System.out.println(user.getCity().getCid());
            System.out.println(user.getCity().getCname());
            System.out.println(user.getCity().getPid());
            System.out.println(user.getCity().getType());
            System.out.println(user.getIsSel());
            System.out.println(user.getUid());
        }
    }


    @Test
    void deleteUserAddressTest(){
        service.deleteUserAddress("1578412234232");
    }


    @Test
    void addUserAddressTest(){
        /*UserAddress user=new UserAddress();
        user.setAddressId("1578412234232");
        user.setAddressName("白蕉镇 金坑南二苑88号");
        user.setAddressTel("13727074222");
        user.setUid("1578412688888");
        user.setAddressUser("陈伟瀚");
        user.setIsSel(1);
        City city=new City();
        city.setCid(851);
        user.setCity(city);
        service.addUserAddress(user);*/


    }

    @Test
    void updateUserAddressTest(){
        /*UserAddress user=new UserAddress();
        user.setAddressId("1578412234232");
        user.setAddressName("白蕉镇 金坑南二苑88号");
        user.setAddressTel("13727074222");
        user.setUid("1578412688888");
        user.setAddressUser("陈伟瀚");
        user.setIsSel(1);
        City city=new City();
        city.setCid(851);
        user.setCity(city);
        service.updateUserAddress(user);*/
    }
}
