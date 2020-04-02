package edu.nf.shopping.user.controller;

import edu.nf.shopping.user.entity.UserAddress;
import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.user.service.UserAddressService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Vera
 * @date 2020/4/3
 */
@RestController
public class UserAddressController extends BaseController {

    @Autowired
    private UserAddressService service;

    @GetMapping("/list/allAddress")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVO listUserAddress(HttpSession session){
        UserInfo user=(UserInfo)session.getAttribute("user");
        List<UserAddress> list=service.listUserAddress(user.getUserId());
        if(list!=null){
            return success(list);
        }
        return success(221,"没有收货地址！");
    }


    @PostMapping("/delete/address")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVO deleteUserAddress(String addressId){
        service.deleteUserAddress(addressId);
        return success(200);
    }

    @PostMapping("/add/address")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVO addUserAddress(@RequestBody UserAddress userAddress){
        service.addUserAddress(userAddress);
        return success(200);
    }

    @PostMapping("/update/address")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVO updateUserAddress(@RequestBody UserAddress userAddress){
        service.updateUserAddress(userAddress);
        return success(200);
    }




}
