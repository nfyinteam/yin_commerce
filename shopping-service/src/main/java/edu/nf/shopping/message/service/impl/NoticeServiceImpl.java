package edu.nf.shopping.message.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.shopping.comment.entity.Comment;
import edu.nf.shopping.comment.exception.CommentException;
import edu.nf.shopping.message.dao.NewsDao;
import edu.nf.shopping.message.dao.NoticeDao;
import edu.nf.shopping.message.dao.ReceiveDao;
import edu.nf.shopping.message.dao.UserSetUpDao;
import edu.nf.shopping.message.entity.Notice;
import edu.nf.shopping.message.exception.MessageException;
import edu.nf.shopping.message.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/4/4
 */
@Service("noticeService")
@Transactional(rollbackFor = {RuntimeException.class})
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private ReceiveDao receiveDao;

    @Autowired
    private UserSetUpDao userSetUpDao;

    @Override
    @Cacheable(value="messageCache",key="#userId+'-'+#noticeType")
    public List<Notice> userListNotice(String noticeType,String userId) {
        try{
            List<Notice> list=noticeDao.userListNotice(noticeType,userId);
            receiveDao.updateNoticeState(noticeType,userId);
            return list;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new MessageException("数据库出错");
        }
    }

    @Override
    public List<Notice> listNotViewByUserId(String userId) {
        try{
            List<Notice> list=noticeDao.listNotViewByUserId(userId);
            Notice notice=new Notice();
            notice.setUserSetUpList(userSetUpDao.listUserMessageSetUp(userId));
            notice.setNewMessageNum(newsDao.findNotViewByUserId(userId));
            list.add(notice);
            return list;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new MessageException("数据库出错");
        }
    }

    @Override
    public int addNotice(Notice notice) {
        try{
            return noticeDao.addNotice(notice);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new MessageException("数据库出错");
        }
    }

}