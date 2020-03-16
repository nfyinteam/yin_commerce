package edu.nf.shopping.comment.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.shopping.comment.dao.CommentDao;
import edu.nf.shopping.comment.entity.Comment;
import edu.nf.shopping.comment.exception.CommentException;
import edu.nf.shopping.comment.service.CommentService;
import edu.nf.shopping.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/12
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public PageInfo<Comment> listBuyShow(Integer pageNum,Integer pageSize,Integer replySize,String goodsId,String order) {
        try{
            List<Comment> byShowList=commentDao.listBuyShow(pageNum,pageSize,goodsId,order);
            //查询买家秀的子评论
            if(byShowList.size()>0){
                for (Comment comment : byShowList) {
                    //comment.setCommentList(commentDao.listByComment(0,replySize,comment.getComId()));
                }
            }
            PageInfo<Comment> pageInfo=new PageInfo(byShowList);
            return pageInfo;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new CommentException("数据库出错");
        }
    }

    @Override
    public PageInfo<Comment> listComment(Integer pageNum, Integer pageSize, String comId) {
        try{
            System.out.println(pageNum+"/"+pageSize+"/"+comId);
            List<Comment> list=commentDao.listByComment(pageNum,pageSize,comId);
            PageInfo<Comment> pageInfo=new PageInfo(list);
            return pageInfo;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new CommentException("数据库出错");
        }
    }

    @Override
    public void addComment(Comment comment) {
        try{
            comment.setComId(UUIDUtils.createUUID());
            comment.setState("1");
            comment.setTime(new Date());
            System.out.println(comment);
            commentDao.addComment(comment);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new CommentException("数据库出错");
        }
    }


    @Override
    public void updateComment(Comment comment) {

    }

    @Override
    public void deleteComment(Comment comment) {

    }
}