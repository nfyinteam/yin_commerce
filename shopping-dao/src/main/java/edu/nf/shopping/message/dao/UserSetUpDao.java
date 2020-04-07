package edu.nf.shopping.message.dao;

import edu.nf.shopping.message.entity.UserSetUp;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/4/1
 */
public interface UserSetUpDao {

    List<UserSetUp> listUserMessageSetUp(String userId);

    void addUserSetUp(UserSetUp userSetUp);

    void deleteUserSetUp(UserSetUp userSetUp);
}