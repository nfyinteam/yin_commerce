package edu.nf.shopping.user.service.impl;

import edu.nf.shopping.user.dao.UserDao;
import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.user.exception.UserException;
import edu.nf.shopping.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Vera
 * @date 2020/4/2
 */


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public UserInfo userLoginByPhone(UserInfo userInfo) {
        try{
            UserInfo user=dao.userLoginByPhone(userInfo);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            throw new UserException("手机号登入失败");
        }

    }

    @Override
    public UserInfo userLoginByEmail(UserInfo userInfo) {
        try{
            UserInfo user=dao.userLoginByEmail(userInfo);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            throw new UserException("邮箱登入失败");
        }

    }

    @Override
    public void addUserByPhone(UserInfo userInfo) {
        try{
            dao.addUserByPhone(userInfo);
        }catch (Exception e){
            e.printStackTrace();
            throw new UserException("手机号注册失败");
        }
    }

    @Override
    public void addUserByEmail(UserInfo userInfo) {
        try{
            dao.addUserByEmail(userInfo);
        }catch (Exception e){
            e.printStackTrace();
            throw new UserException("邮箱注册失败");
        }
    }
}
