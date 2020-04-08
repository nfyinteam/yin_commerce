package edu.nf.shopping.comment.service.impl;

import com.rabbitmq.client.Channel;
import edu.nf.shopping.comment.config.CommentRabbitConfig;
import edu.nf.shopping.comment.dao.CommentDao;
import edu.nf.shopping.comment.dao.PraiseDao;
import edu.nf.shopping.comment.entity.Praise;
import edu.nf.shopping.comment.exception.CommentException;
import edu.nf.shopping.comment.service.PraiseService;
import edu.nf.shopping.config.RabbitConfig;
import edu.nf.shopping.message.dao.NoticeDao;
import edu.nf.shopping.message.dao.ReceiveDao;
import edu.nf.shopping.message.entity.Notice;
import edu.nf.shopping.message.entity.Receive;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Date;
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

    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private ReceiveDao receiveDao;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

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
    public void spotPraise(String userId, String comId,String goodsId,String receiveUserId) {
        try {
            if (userId ==null||userId==""||comId == null || comId == "" || receiveUserId == null || receiveUserId == "") {
                throw new CommentException("数据错误了！");
            }
            Praise praise = new Praise();
            praise.setPraId(userId + comId);
            praise.setUserId(userId);
            praise.setComId(comId);
            praise.setTime(new Date());
            praise.setGoodsId(goodsId);
            praise.setReceiveUserId(receiveUserId);
            CorrelationData correlationData = new CorrelationData();
            correlationData.setId(praise.getPraId() + praise.getTime());
            rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, CommentRabbitConfig.PRAISE_ROUTER_KEY, praise, correlationData);
        }catch (CommentException e){
            throw e;
        } catch (RuntimeException e){
            e.printStackTrace();
            throw new CommentException("信息出错了！");
        }
    }

    /**
     点赞消费者：专门处理点赞业务
     **/
    @RabbitListener(queues = CommentRabbitConfig.PRAISE_QUEUE)
    //@CacheEvict(value = "commentCache", key = "#praise.goodsId")
    public void receiveMessage(Praise praise, @Headers Map<String, Object> headers, Channel channel){
        try{
            System.out.println(praise.toString());
            //判断是否已点过
            if(praiseDao.findPraise(praise.getUserId(),praise.getComId())==null){
                //点赞通知记录
                Notice notice = new Notice();
                notice.setNoticeId(praise.getPraId());
                notice.setContent("赞了我的评论");
                notice.setLink("NULL");
                notice.setTime(praise.getTime());
                notice.setType("1");
                notice.setAuthor(praise.getUserId());
                notice.setTitle("赞了我的评论");
                notice.setComId(praise.getComId());
                //接收者记录
                Receive receive=new Receive();
                receive.setMessageId(praise.getPraId());
                receive.setReceiveUserId(praise.getReceiveUserId());
                receive.setState("1");
                //添加记录
                praiseDao.addPraise(praise);
                receiveDao.addReceive(receive);
                noticeDao.addNotice(notice);
            }else {
                praiseDao.deletePraise(praise.getUserId(),praise.getComId());
            }
            //清除接收方的点赞消息缓存
            redisTemplate.delete("messageCache::"+praise.getReceiveUserId()+"-1");
            //确认签收
            Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
            channel.basicAck(deliveryTag, false);
        }catch (RuntimeException | IOException e){
            e.printStackTrace();
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