package edu.nf.shopping.message.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import edu.nf.shopping.config.RedisConfig;
import edu.nf.shopping.message.entity.News;
import edu.nf.shopping.message.entity.PersonnelAssignment;
import edu.nf.shopping.message.service.RedisMsg;
import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.util.LettuceUtils;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Bull fighters
 * @date 2020/4/9
 */
@Service("webSocketHandlerImpl")
public class WebSocketHandlerImpl implements WebSocketHandler {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 保存该服务器正在连接用户的WebSocketSession
     */
    private static Map<String,WebSocketSession> socketMap = new HashMap<String, WebSocketSession>();

    /**
     * 获取lettuce操作对象
     */
    private static RedisCommands<String, Object> commands = LettuceUtils.getCommands();

    /**
     * 所有在线客服的记录
     */
    private List<PersonnelAssignment> personnelAssignments=null;

    /**
     * 客服与用户的连接记录key
     */
    private List<String> alreadyAssignment =new ArrayList<>();

    /**
     *在线客服的服务人数记录key
     */
    private List<String> serviceValue=new ArrayList<>();

    /**
     * 客服与用户不通信的最大时间（秒）
     */
    public final int OUT_TIME=30;

    public final String ASSIGNMENT_CACHE_KEY="assignment_cache:";

    public final String CUSTOMER_SERVICE_RECEIPT_NUM_KEY="customer_service_receiptNum_cache:";

    private static TextMessage receiveMessage =null;

    /**
     * 用户连接成功
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        try {
            UserInfo userInfo = (UserInfo)session.getAttributes().get("userInfo");
            if(userInfo!=null) {
                //用户才进行分配客服
                if (socketMap.get(userInfo.getUserId()) == null) {
                    socketMap.put(userInfo.getUserId(), session);
                    //创建虚假客服人员
//                    redisTemplate.opsForValue().set(CUSTOMER_SERVICE_RECEIPT_NUM_KEY+"1578412684888",
//                            new PersonnelAssignment("1578412684888",0));
//                    redisTemplate.opsForValue().set(CUSTOMER_SERVICE_RECEIPT_NUM_KEY+"1578412681",
//                            new PersonnelAssignment("15784126841",2));
//                    redisTemplate.opsForValue().set(CUSTOMER_SERVICE_RECEIPT_NUM_KEY+"1578412682",
//                            new PersonnelAssignment("1578412682",2));
//                    redisTemplate.opsForValue().set(CUSTOMER_SERVICE_RECEIPT_NUM_KEY+"1578412683",
//                            new PersonnelAssignment("1578412683",2));
                }
                if("true".equals(userInfo.getNecessaryCustomerService())){
                    customerServiceAssignment(userInfo.getUserId());
                }else {
                    alreadyAssignment=commands.keys(ASSIGNMENT_CACHE_KEY+"*:"+userInfo.getUserId());
                    if(alreadyAssignment.size()>0){
                        connectMessage(alreadyAssignment.get(0).split(":")[1],userInfo.getUserId(),"");
                    }
                }
            }
        }catch (RuntimeException e){
            e.getMessage();
        }
    }

    /**
     * 给用户分配一个客服：
     * 先判断该用户有没有连接记录
     * 再模糊查询在线客服，排序后找出最少服务人数的客服
     * 给该用户一个链接记录并改变客服的服务人数
     * 返回客服编号给对应用户
     * @param userId
     * @return
     */
    private String customerServiceAssignment(String userId){
        alreadyAssignment=commands.keys(ASSIGNMENT_CACHE_KEY+"*:"+userId);
        if(alreadyAssignment.size()<=0) {
            serviceValue = commands.keys(CUSTOMER_SERVICE_RECEIPT_NUM_KEY+"*");
            personnelAssignments=new ArrayList<>();
            for (String s : serviceValue) {
                personnelAssignments.add((PersonnelAssignment)redisTemplate.opsForValue().get(s));
            }
            Collections.sort(personnelAssignments);
            if(personnelAssignments.size()>0){
                redisTemplate.opsForValue().set(ASSIGNMENT_CACHE_KEY+
                                personnelAssignments.get(0).getCustomerServiceId()+":"+userId,
                                userId,OUT_TIME, TimeUnit.SECONDS);
                redisTemplate.opsForValue().set(CUSTOMER_SERVICE_RECEIPT_NUM_KEY+
                                personnelAssignments.get(0).getCustomerServiceId(),
                        new PersonnelAssignment(personnelAssignments.get(0).getCustomerServiceId(),
                                    commands.keys(ASSIGNMENT_CACHE_KEY+personnelAssignments.
                                            get(0).getCustomerServiceId()+":*").size()));
                connectMessage(personnelAssignments.get(0).getCustomerServiceId(),userId,"连接成功");
                connectMessage(userId,personnelAssignments.get(0).getCustomerServiceId(),"");
                System.out.println("匹配到的："+personnelAssignments.get(0));
            }else {
                connectMessage("null",userId,"没有客服了哦");
            }
        }
        return null;
    }

    /**
     * 分配连接的信息
     * @param customerServiceId
     * @param userId
     */
    private void connectMessage(String customerServiceId,String userId,String content){
        News news=new News();
        news.setOrderId("NULL");
        news.setContent(content);
        news.setAuthorId(customerServiceId);
        news.setReceiveUserId(userId);
        news.setNewsType("3");
        receiveMessage(news);
    }

    /**
     *  接收socket信息
     */
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        System.out.println("收到信息"+webSocketMessage.toString());
        //String userId = (String) webSocketSession.getAttributes().get("userId");
        //webSocketSession.sendMessage(new TextMessage("aaa"));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        System.out.println("连接出错"+exception.getMessage());
    }

    /**
     * 用户断开连接
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status){
        //从作用域获取用户信息
        UserInfo userInfo = (UserInfo) session.getAttributes().get("userInfo");
        if(socketMap.get(userInfo.getUserId())!=null) {
            socketMap.remove(userInfo.getUserId());
        }
        System.out.println("连接已关闭：" + status);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 发送信息给指定用户
     * @param news
     * @return
     */
    public void receiveMessage(News news) {
        WebSocketSession receiveSession = socketMap.get(news.getReceiveUserId());
        System.out.println("监听中："+news.toString());
        try {
            if(receiveSession==null||!receiveSession.isOpen()) {
                return ;
            }
            receiveMessage = new TextMessage(JSON.toJSONString(news));
            System.out.println("成功发送消息："+JSON.toJSONString(news));
            receiveSession.sendMessage(receiveMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}