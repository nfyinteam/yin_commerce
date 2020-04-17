package edu.nf.shopping.user.service.impl;

import edu.nf.shopping.user.dao.UserAddressDao;
import edu.nf.shopping.user.entity.UserAddress;
import edu.nf.shopping.user.exception.UserException;
import edu.nf.shopping.user.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vera
 * @date 2020/4/3
 */
@Service("userAddressService")
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressDao dao;

    @Override
    public List<UserAddress> listUserAddress(String uid) {
        try{
            List<UserAddress> list=dao.listUserAddress(uid);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            throw new UserException("服务器出现问题，查找收货地址失败！");
        }

    }

    @Override
    public void updateUserAddress(UserAddress userAddress) {
        try{
            dao.updateUserAddress(userAddress);
        }catch (Exception e){
            e.printStackTrace();
            throw new UserException("服务器出现问题，更新地址是吧！");
        }
    }

    @Override
    public void addUserAddress(UserAddress userAddress) {
        try{
            dao.addUserAddress(userAddress);
        }catch (Exception e){
            e.printStackTrace();
            throw new UserException("服务器出现问题，添加地址失败！");
        }
    }

    @Override
    public void deleteUserAddress(String addressId) {
        try{
            dao.deleteUserAddress(addressId);
        }catch (Exception e){
            e.printStackTrace();
            throw new UserException("服务器出现问题，删除地址失败！");
        }
    }
}
