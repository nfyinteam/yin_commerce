package edu.nf.shopping.user.service;

import edu.nf.shopping.user.entity.UserAddress;

import java.util.List;

/**
 * @author Vera
 * @date 2020/4/3
 */
public interface UserAddressService {

    List<UserAddress> listUserAddress(String uid);

    void updateUserAddress(UserAddress userAddress);

    void addUserAddress(UserAddress userAddress);

    void deleteUserAddress(String addressId);
}
