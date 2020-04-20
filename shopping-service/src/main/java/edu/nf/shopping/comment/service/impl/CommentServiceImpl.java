package edu.nf.shopping.comment.service.impl;

import com.github.pagehelper.PageInfo;
import com.rabbitmq.client.Channel;
import edu.nf.shopping.comment.config.CommentRabbitConfig;
import edu.nf.shopping.comment.dao.ComImageDao;
import edu.nf.shopping.comment.dao.CommentDao;
import edu.nf.shopping.comment.dao.ImgInfoDao;
import edu.nf.shopping.comment.entity.Comment;
import edu.nf.shopping.comment.entity.CommentImage;
import edu.nf.shopping.comment.entity.ImgInfo;
import edu.nf.shopping.comment.entity.Praise;
import edu.nf.shopping.comment.exception.CommentException;
import edu.nf.shopping.comment.service.CommentService;
import edu.nf.shopping.config.RabbitConfig;
import edu.nf.shopping.message.dao.NoticeDao;
import edu.nf.shopping.message.dao.ReceiveDao;
import edu.nf.shopping.message.entity.Notice;
import edu.nf.shopping.message.entity.Receive;
import edu.nf.shopping.message.exception.MessageException;
import edu.nf.shopping.order.dao.OrderDetailsDao;
import edu.nf.shopping.util.FileNameUtils;
import edu.nf.shopping.util.UUIDUtils;
import edu.nf.shopping.util.UploadAddressUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Bull fighters
 * @date 2020/3/12
 */
@Service("commentService")
@Transactional(rollbackFor = RuntimeException.class)
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private ComImageDao comImageDao;

    @Autowired
    private ImgInfoDao imgInfoDao;

    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private ReceiveDao receiveDao;

    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 根据条件查询商品的评价
     * @param pageNum 页码
     * @param pageSize 条目数
     * @param replySize 回复评论数量
     * @param goodsId 商品编号
     * @param userId 用户编号
     * @param dataTime 时间
     * @param order 排序
     * @param commentType 是否包含图片
     * @return
     */
    @Override
    @Cacheable(value = "commentCache", key = "#goodsId" , condition = "#userId==null and #pageNum<=1 and #order=='0' and #commentType=='0'")
    public PageInfo<Comment> listBuyShow(Integer pageNum,Integer pageSize,Integer replySize,String goodsId,String userId,Date dataTime,String order,String commentType) {
        try{
            List<Comment> buyShowList=commentDao.listBuyShow(pageNum,pageSize,goodsId,userId,dataTime,order,commentType);
            //查询买家秀的子评论、图片
            if(buyShowList.size()>0){
                for (Comment comment : buyShowList) {
                    comment.setImgInfoList(imgInfoDao.listImgInfo(comment.getComId()));
                    comment.setCommentList(commentDao.listByComment(0,replySize,comment.getComId(),userId,dataTime,order));
                }
            }
            PageInfo<Comment> pageInfo=new PageInfo(buyShowList);
            return pageInfo;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new CommentException("数据库出错");
        }
    }

    /**
     * 根据条件查询商品的评论
     * @param pageNum 页码
     * @param pageSize 条目数
     * @param comId 评论编号
     * @param userId 用户编号
     * @param dataTime 时间
     * @param order 排序
     * @return
     */
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

    /**
     *查询待审核的买家秀
     */
    @Override
    public PageInfo<Comment> listStayToExamineBuyShow(Integer pageNum, Integer pageSize) {
        try{
            List<Comment> list=commentDao.listStayToExamineBuyShow(pageNum,pageSize);
            if(list.size()>0){
                for (Comment comment : list) {
                    comment.setImgInfoList(imgInfoDao.listImgInfo(comment.getComId()));
                }
            }
            System.out.println("待审的："+list.size());
            PageInfo<Comment> pageInfo=new PageInfo(list);
            return pageInfo;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new CommentException("数据库出错");
        }
    }

    /**
     * 查询被举报的评论或买家秀
     * @param pageNum
     * @param pageSize
     * @param type 评论类型
     * @return
     */
    @Override
    public PageInfo<Comment> listReportComment(Integer pageNum, Integer pageSize, String type) {
        try{
            List<Comment> list=commentDao.listReportComment(pageNum,pageSize,type);
            if("1".equals(type) && list.size()>0){
                for (Comment comment : list) {
                    comment.setImgInfoList(imgInfoDao.listImgInfo(comment.getComId()));
                }
            }
            System.out.println("举报的："+list.size());
            PageInfo<Comment> pageInfo=new PageInfo(list);
            return pageInfo;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new CommentException("数据库出错");
        }
    }

    @Override
    public Comment findComment(String comId, String goodsId,String userId) {
        return null;
    }

    /**
     * 添加买家秀
     **/
    @Override
    public void addBuyShow(MultipartFile[] files,Comment comment) throws IOException{
        try{
            if(files.length>5){
                throw new CommentException("出错了喔");
            }
            comment.setComId(UUIDUtils.createUUID());
            comment.setState("2");
            comment.setTime(new Date());
            comment.setGrade("1");
            //需要调用订单的sku
            comment.setSkuInfo("");
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

    /**
     * 添加评论
     **/
    @Override
    public void addComment(Comment comment) {
        try{
            if(comment.getReceiveUserId()==null || "".equals(comment.getReceiveUserId())
                    || comment.getBycId()==null || "".equals(comment.getBycId())
                    || comment.getGoodsId()==null || "".equals(comment.getGoodsId())
                    || comment.getUserId()==null){
                throw new CommentException("数据出错了");
            }
            comment.setComId(UUIDUtils.createUUID());
            comment.setTime(new Date());
            CorrelationData correlationData=new CorrelationData();
            correlationData.setId(comment.getComId());
            rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME,
                    CommentRabbitConfig.COMMENT_ROUTER_KEY,comment);
        }catch (CommentException e){
            throw e;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new CommentException("数据库出错");
        }
    }

    /**
     * 回复消息的消费者，负责发送回复消息
     * @param comment
     * @param headers
     * @param channel
     */
    @RabbitListener(queues = CommentRabbitConfig.COMMENT_QUEUE)
    public void commentMessage(Comment comment, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        try{
            //消息记录
            comment.setState("1");
            comment.setSkuInfo("NULL");
            comment.setOrderId("NULL");
            comment.setTime(new Date());
            comment.setGrade(comment.getBycId().equals(comment.getParentId())?"2":"3");
            comment.setComScore("NULL");
            //点赞通知记录
            Notice notice = new Notice();
            notice.setNoticeId(UUIDUtils.createUUID());
            notice.setTitle("回复了我");
            notice.setContent(comment.getContent());
            notice.setLink("NULL");
            notice.setTime(comment.getTime());
            notice.setType("0");
            notice.setAuthor(comment.getUserId());
            notice.setComId(comment.getComId());
            //接收者记录
            Receive receive=new Receive();
            receive.setMessageId(notice.getNoticeId());
            receive.setReceiveUserId(comment.getReceiveUserId());
            receive.setState("1");
            //添加记录
            commentDao.addComment(comment);
            receiveDao.addReceive(receive);
            noticeDao.addNotice(notice);
            //清除接收方的回复消息和评论的缓存
            redisTemplate.delete("messageCache::"+comment.getReceiveUserId()+"-"+notice.getType());
            redisTemplate.delete("commentCache::"+comment.getGoodsId());
            //确认签收
            channel.basicAck(deliveryTag, false);
        }catch (RuntimeException e){
            //拒收消息，丢到死信
            channel.basicReject(deliveryTag, false);
            e.printStackTrace();
            throw new MessageException(e.getMessage());
        }
    }

    /**
     * 接收回复消息的死信
     * @param message
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = CommentRabbitConfig.COMMENT_DEAD_QUEUE)
    public void commentDeadMessage(Message message, Channel channel) throws IOException {
        System.out.println("收到死信消息：" + new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

    /**
     * 用户删除自己的评论
     * @param comId
     * @param state
     * @param userId
     */
    @Override
    public void updateCommentState(String comId, String state, String userId) {
        try{
            if("".equals(comId)||comId==null){
                throw new CommentException("出错了！");
            }
            commentDao.updateComment(comId,state);
        }catch (CommentException e){
            throw e;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new CommentException("数据库出错");
        }
    }

    @Override
    public void deleteComment(Comment comment) {

    }
}