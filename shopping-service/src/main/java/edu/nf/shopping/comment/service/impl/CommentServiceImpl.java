package edu.nf.shopping.comment.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.shopping.comment.dao.CommentDao;
import edu.nf.shopping.comment.entity.Comment;
import edu.nf.shopping.comment.exception.CommentException;
import edu.nf.shopping.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public PageInfo<Comment> listBuyShow(Integer pageNum,Integer pageSize,String goodsId,String order) {
        try{
            List<Comment> byShowList=commentDao.listBuyShow(pageNum,pageSize,goodsId,order);
            //查询买家秀的图片

            //查询买家秀的子评论
            if(byShowList.size()>0){
                List<Comment> ComList=commentDao.listByComment(1,3,byShowList,"");
                byShowList.addAll(ComList);
            }
            PageInfo<Comment> pageInfo=new PageInfo(byShowList);
            return pageInfo;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new CommentException("数据库出错");
        }

    }

}