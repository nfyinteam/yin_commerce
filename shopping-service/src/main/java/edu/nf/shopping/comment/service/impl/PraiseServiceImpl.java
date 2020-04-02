package edu.nf.shopping.comment.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.shopping.comment.dao.CommentDao;
import edu.nf.shopping.comment.dao.PraiseDao;
import edu.nf.shopping.comment.entity.Comment;
import edu.nf.shopping.comment.entity.Praise;
import edu.nf.shopping.comment.exception.CommentException;
import edu.nf.shopping.comment.service.PraiseService;
import edu.nf.shopping.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/19
 */
@Service("praiseService")
@Transactional(rollbackFor = RuntimeException.class)
public class PraiseServiceImpl implements PraiseService {

    @Autowired
    private PraiseDao praiseDao;

    @Autowired
    private CommentDao commentDao;

    @Override
    public Praise findPraise(String userId, String comId) {
        try{
            Praise praise=praiseDao.findPraise(userId,comId);
            return praise;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new CommentException("数据库出错");
        }
    }

    @Override
    public Boolean spotPraise(String userId, String comId) {
        try{
            if(commentDao.findComment(comId,null,null)==null){
                throw new CommentException("出错了！");
            }
            if(praiseDao.findPraise(userId,comId)==null){
                Praise praise=new Praise();
                praise.setPraId(UUIDUtils.createUUID());
                praise.setUserId(userId);
                praise.setComId(comId);
                praise.setTime(new Date());
                praiseDao.addPraise(praise);
                return true;
            }else {
                praiseDao.deletePraise(userId,comId);
                return false;
            }
        }catch (CommentException e){
            throw e;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new CommentException("数据库出错");
        }
    }

    @Override
    public void deletePraise(String userId, String comId) {
        try{
            if(commentDao.findComment(comId,null,null)==null){
                throw new CommentException("出错了！");
            }
            praiseDao.deletePraise(userId,comId);
        }catch (CommentException e){
            throw e;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new CommentException("数据库出错");
        }
    }
}