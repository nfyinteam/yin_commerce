package edu.nf.shopping.comment.service.impl;

import com.github.pagehelper.PageInfo;
import com.rabbitmq.client.Channel;
import edu.nf.shopping.comment.dao.CommentDao;
import edu.nf.shopping.comment.dao.PraiseDao;
import edu.nf.shopping.comment.entity.Comment;
import edu.nf.shopping.comment.entity.Praise;
import edu.nf.shopping.comment.exception.CommentException;
import edu.nf.shopping.comment.service.PraiseService;
import edu.nf.shopping.config.RabbitConfig;
import edu.nf.shopping.util.UUIDUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    /*@Autowired
    private NoticeDao noticeDao;*/

    @Autowired
    private RabbitTemplate rabbitTemplate;

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
    public void spotPraise(String userId, String comId,String goodsId) {
        Praise praise=new Praise();
        praise.setPraId(userId+comId);
        praise.setUserId(userId);
        praise.setComId(comId);
        praise.setTime(new Date());
        praise.setGoodsId(goodsId);
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(praise.getPraId()+praise.getTime());
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "praise.message", praise, correlationData);
    }

    /**
     点赞消费者：专门处理点赞业务
     **/
    @RabbitListener(queues = RabbitConfig.PRAISE_QUEUE)
    public void receiveMessage(Praise praise,
                               @Headers Map<String, Object> headers,
                               Channel channel){
        try{
            //发送点赞消息
            if(praiseDao.addPraise(praise)>0){
                System.out.println(111);
                /*Notice notice = new Notice();
                notice.setNoticeId(praise.getUserId() + praise.getComId());
                notice.setContent("赞了我的评论");
                notice.setLink("NULL");
                notice.setTime(praise.getTime());
                notice.setType("1");
                notice.setAuthor(praise.getUserId());
                notice.setTitle("NULL");*/
                //noticeDao.addNotice(notice);
                //确认签收
                Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
                channel.basicAck(deliveryTag, false);
            }
        }catch (RuntimeException | IOException e){
            e.printStackTrace();
            throw new CommentException("信息出错了！");
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