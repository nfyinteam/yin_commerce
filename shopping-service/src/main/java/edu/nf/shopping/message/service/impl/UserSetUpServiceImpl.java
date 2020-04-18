package edu.nf.shopping.message.service.impl;

import edu.nf.shopping.message.dao.UserSetUpDao;
import edu.nf.shopping.message.entity.UserSetUp;
import edu.nf.shopping.message.exception.MessageException;
import edu.nf.shopping.message.service.UserSetUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/4/16
 */
@Service("userSetUpService")

public class UserSetUpServiceImpl implements UserSetUpService {

    @Autowired
    private UserSetUpDao userSetUpDao;

    @Override
    public List<UserSetUp> listUserMessageSetUp(String userId) {
        try{
            List<UserSetUp> list=userSetUpDao.listUserMessageSetUp(userId);
            for (UserSetUp userSetUp : list) {
                System.out.println(userSetUp);
            }
            return list;
        }catch (RuntimeException e){
            throw new MessageException(e.getMessage());
        }
    }

    @Override
    public void addUserSetUp(String userId,String type) {
        try{
            UserSetUp userSetUp=new UserSetUp();
            userSetUp.setUsnId(userId+type);
            userSetUp.setUserId(userId);
            userSetUp.setTypeId(type);
            System.out.println("add:"+userSetUp);
            userSetUpDao.addUserSetUp(userSetUp);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new MessageException(e.getMessage());
        }
    }

    @Override
    public void deleteUserSetUp(String userId,String type) {
        try{
            UserSetUp userSetUp=new UserSetUp();
            userSetUp.setUserId(userId);
            userSetUp.setTypeId(type);
            System.out.println("delete:"+userSetUp);
            userSetUpDao.deleteUserSetUp(userSetUp);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new MessageException(e.getMessage());
        }
    }
}