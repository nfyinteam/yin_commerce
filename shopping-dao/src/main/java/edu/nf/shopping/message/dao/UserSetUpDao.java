package edu.nf.shopping.message.dao;

import edu.nf.shopping.message.entity.UserSetUp;

/**
 * @author Bull fighters
 * @date 2020/4/1
 */
public interface UserSetUpDao {

    void addUserSetUp(UserSetUp userSetUp);

    void deleteUserSetUp(UserSetUp userSetUp);
}