package edu.nf.shopping.comment.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.shopping.comment.dao.ComImageDao;
import edu.nf.shopping.comment.dao.CommentDao;
import edu.nf.shopping.comment.dao.ImgInfoDao;
import edu.nf.shopping.comment.entity.Comment;
import edu.nf.shopping.comment.entity.CommentImage;
import edu.nf.shopping.comment.entity.ImgInfo;
import edu.nf.shopping.comment.exception.CommentException;
import edu.nf.shopping.comment.service.CommentService;
import edu.nf.shopping.util.FileNameUtils;
import edu.nf.shopping.util.UUIDUtils;
import edu.nf.shopping.util.UploadAddressUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @Autowired
    private ComImageDao comImageDao;

    @Autowired
    private ImgInfoDao imgInfoDao;

    @Override
    public PageInfo<Comment> listBuyShow(Integer pageNum,Integer pageSize,Integer replySize,String goodsId,String userId,Date dataTime,String order,String commentType) {
        try{
            List<Comment> byShowList=commentDao.listBuyShow(pageNum,pageSize,goodsId,userId,dataTime,order,commentType);
            //查询买家秀的子评论和图片
            if(byShowList.size()>0){
                for (Comment comment : byShowList) {
                    comment.setImgInfoList(imgInfoDao.listImgInfo(comment.getComId()));
                    comment.setCommentList(commentDao.listByComment(0,replySize,comment.getComId(),userId,dataTime,order));
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
    public PageInfo<Comment> listComment(Integer pageNum, Integer pageSize, String comId,String userId,Date dataTime,String order) {
        try{
            List<Comment> list=commentDao.listByComment(pageNum,pageSize,comId,userId,dataTime,order);
            PageInfo<Comment> pageInfo=new PageInfo(list);
            return pageInfo;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new CommentException("数据库出错");
        }
    }

    @Override
    public Comment findComment(String comId, String goodsId) {
        return null;
    }

    @Override
    public void addBuyShow(MultipartFile[] files,Comment comment) throws IOException{
        try{
            if(files.length>5){
                throw new CommentException("出错了啊！");
            }
            comment.setComId(UUIDUtils.createUUID());
            comment.setState("2");
            comment.setTime(new Date());
            comment.setGrade("1");
            comment.setParentId("NULL");
            comment.setBycId("NULL");
            commentDao.addComment(comment);
            for (int i=0;i<files.length;i++) {
                //图片信息
                ImgInfo imgInfo=new ImgInfo();
                imgInfo.setImgId(UUIDUtils.createUUID());
                imgInfo.setImgName(UUIDUtils.createUUID()+".png");
                imgInfo.setImgFile("NULL");
                imgInfo.setImgType(2);
                imgInfoDao.addImgInfo(imgInfo);
                //图片与评论关联
                CommentImage commentImage=new CommentImage();
                commentImage.setImageId(imgInfo.getImgId());
                commentImage.setComId(comment.getComId());
                commentImage.setIndex(i);
                comImageDao.addCommentImage(commentImage);
                FileNameUtils.upload(UploadAddressUtils.COMMENT_IMAGES,files[i].getInputStream(),imgInfo.getImgName());
            }
        }catch (CommentException e){
            throw e;
        }
        catch (RuntimeException e){
            e.printStackTrace();
            throw new CommentException("数据库出错");
        }
    }

    @Override
    public void addComment(Comment comment) {
        try{
            //判断被回复的评论是否存在
            if(comment.getBycId()!=null && !"".equals(comment.getBycId()) && comment.getGoodsId()!=null && !"".equals(comment.getGoodsId())){
                if(commentDao.findComment(comment.getBycId(),comment.getGoodsId())!=null){
                    comment.setComId(UUIDUtils.createUUID());
                    comment.setState("1");
                    comment.setTime(new Date());
                    comment.setGrade(comment.getBycId().equals(comment.getParentId())?"2":"3");
                    comment.setComScore("NULL");
                    commentDao.addComment(comment);
                }else {
                    throw new CommentException("出错了");
                }
            }
        }catch (CommentException e){
            throw e;
        }
        catch (RuntimeException e){
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