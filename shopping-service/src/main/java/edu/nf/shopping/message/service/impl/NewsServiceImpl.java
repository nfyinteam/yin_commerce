package edu.nf.shopping.message.service.impl;

import com.rabbitmq.client.Channel;
import edu.nf.shopping.config.RabbitConfig;
import edu.nf.shopping.message.config.MessageRabbitConfig;
import edu.nf.shopping.message.dao.NewsDao;
import edu.nf.shopping.message.dao.ReceiveDao;
import edu.nf.shopping.message.entity.News;
import edu.nf.shopping.message.entity.PersonnelAssignment;
import edu.nf.shopping.message.entity.Receive;
import edu.nf.shopping.message.exception.MessageException;
import edu.nf.shopping.message.server.WebSocketHandlerImpl;
import edu.nf.shopping.message.service.NewsService;
import edu.nf.shopping.order.entity.OrderInfo;
import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.util.FileNameUtils;
import edu.nf.shopping.util.LettuceUtils;
import edu.nf.shopping.util.UUIDUtils;
import edu.nf.shopping.util.UploadAddressUtils;
import io.lettuce.core.api.sync.RedisCommands;
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
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Bull fighters
 * @date 2020/4/6
 */
@Service("newsService")
@Transactional(rollbackFor = {RuntimeException.class})
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private ReceiveDao receiveDao;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private WebSocketHandlerImpl webSocketHandler;

    private static RedisCommands<String, Object> commands = LettuceUtils.getCommands();

    @Override
    //@Cacheable(value="messageCache" , key = "chat_record:#orderId" ,condition = "#pageStart=0 and #orderId!=null")
    public List<News> listUserNews(Integer pageStart, Integer pageSize, String userId, String orderId) {
        try{
            pageStart=pageStart<0?0:pageStart;
            List<News> list=newsDao.listUserNews(pageStart,pageSize,userId,orderId);
            if (list.size()>0 && list.size()<pageSize){
                for (News news : list) {
                    System.out.println(news.toString());
                }
                list.get(0).setTotal("0");
            }
            return list;
        }catch (MessageException e){
            e.printStackTrace();
            throw e;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new MessageException("数据库出错");
        }
    }

    /**
     * 判断连接记录key是否过期
     * 添加一条消息记录并发送消息
     * @param news
     * @return
     */
    @Override
    public News addNews(MultipartFile file,News news,String customerService,String userId) {
        try{
            if (news.getOrderId()==null||"".equals(news.getOrderId())||"NULL".equals(news.getOrderId())) {
                if (!redisTemplate.expire((webSocketHandler.ASSIGNMENT_CACHE_KEY + customerService + ":" + userId),
                        webSocketHandler.OUT_TIME, TimeUnit.SECONDS)) {
                    throw new MessageException("连接断开，请刷新界面");
                }
            }
            news.setNewsId(UUIDUtils.createUUID());
            news.setCustomerService(customerService);
            news.setUserId(userId);
            //判断是否为图片消息
            if (file!=null){
                news.setImgName(news.getNewsId()+".png");
                FileNameUtils.upload(UploadAddressUtils.MESSAGE_IMAGES,file.getInputStream(),news.getImgName());
            }else {
                news.setImgName("NULL");
            }
//            CorrelationData correlationData=new CorrelationData();
//            correlationData.setId(news.getNewsId());
            rabbitTemplate.convertAndSend(RabbitConfig.DIRECT_EXCHANGE_NAME,
                    MessageRabbitConfig.CHAT_NEWS_ROUTER_KEY,news);
            return news;
        }catch (MessageException e){
            throw e;
        }catch (RuntimeException |IOException e){
            e.printStackTrace();
            throw new MessageException("服务器出错了，请刷新界面");
        }
    }

    /**
     * 聊天消息的消费者，负责处理聊天消息
     * @param news
     * @param headers
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = MessageRabbitConfig.CHAT_NEWS_QUEUE)
    public void chatMessage(News news, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        sendNews(news,headers,channel);
    }

//    @RabbitListener(queues = MessageRabbitConfig.CHAT_NEWS_QUEUE)
//    public void chatMessage(News news, @Headers Map<String, Object> headers, Channel channel) throws IOException {
//        sendNews(news,headers,channel);
//    }

    private void sendNews(News news, @Headers Map<String, Object> headers, Channel channel){
        try {
            news.setNewsType("2");
            //根据订单编号和用户编号还有客服编号查询订单是否真实
            if (news.getOrderId()==null||"".equals(news.getOrderId())||"NULL".equals(news.getOrderId())) {
//                if(redisTemplate.opsForValue().get(webSocketHandler.ASSIGNMENT_CACHE_KEY+
//                        news.getCustomerService() +":"+news.getUserId())==null){

//                }
//                if(){
                //                  news.setContent("连接断开，请刷新界面");
////                    news.setReceiveUserId(news.getAuthorId());
////                    webSocketHandler.receiveMessage(news);
////                    return;
//                }
            }
            //news.setReceiveUserId("1578412684888");
            news.setTime(new Date());
            Receive receive=new Receive();
            receive.setMessageId(news.getNewsId());
            receive.setReceiveUserId(news.getReceiveUserId());
            receive.setState("1");
            news.setNewsType("1");
//            newsDao.addNews(news);
//            receiveDao.addReceive(receive);
            //redisTemplate.convertAndSend("chat",news);
            webSocketHandler.receiveMessage(news);
//            Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
//            channel.basicAck(deliveryTag, false);
        }catch (RuntimeException e){
            //消息发送失败反馈给发送者
            news.setNewsType("2");
            news.setReceiveUserId(news.getAuthorId());
            webSocketHandler.receiveMessage(news);
            e.printStackTrace();
        }
    }

    @Override
    public void updateNewsState(String newsId,String orderId, String userId) {
        try{
            receiveDao.updateNewsState(newsId,orderId,userId);
        }catch (MessageException e){
            e.printStackTrace();
            throw new MessageException(e.getMessage());
        }
    }

    @Override
    public List<UserInfo> getUserNewsListByUserId(String userId,String customerService) {
        try{
            List<UserInfo> list= newsDao.getUserNewsListByUserId(userId,customerService);
            if("1".equals(customerService)){
                List<String> keys=commands.keys(webSocketHandler.ASSIGNMENT_CACHE_KEY+userId+":*");
                for (String key : keys) {
                    UserInfo u=(UserInfo)redisTemplate.opsForValue().get("userInfo_cache:"+key.split(":")[2]);
                    u.setOrderId("NULL");
                    list.add(u);
                }
            }
            for (UserInfo userInfo : list) {
                System.out.println(userInfo);
            }
            return list;
        }catch (MessageException e){
            e.printStackTrace();
            throw new MessageException(e.getMessage());
        }
    }
}