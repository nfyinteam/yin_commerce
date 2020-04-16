package edu.nf.shopping.message.service;

import edu.nf.shopping.message.entity.UserSetUp;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/4/16
 */
public interface UserSetUpService {
    List<UserSetUp> listUserMessageSetUp(String userId);

    void addUserSetUp(String userId,String type);

    void deleteUserSetUp(String userId,String type);
}