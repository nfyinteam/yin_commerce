package edu.nf.shopping.config.listener;

import com.alibaba.fastjson.JSON;
import edu.nf.shopping.message.entity.News;
import edu.nf.shopping.message.entity.PersonnelAssignment;
import edu.nf.shopping.message.server.WebSocketHandlerImpl;
import edu.nf.shopping.util.LettuceUtils;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Achine
 * @date 2020/4/6
 */
@Component
public class KeyExpiredListener extends KeyExpirationEventMessageListener {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private WebSocketHandlerImpl webSocketHandler;

    private static RedisCommands<String, Object> commands = LettuceUtils.getCommands();

    public KeyExpiredListener(@Qualifier("redisMessageListenerContainer") RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    /**
     * 监听用户与客服的连接key
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String expiredKey = message.toString();
        System.out.println(expiredKey+"到期了");
        if(expiredKey.startsWith("assignment_cache")){
            String[] beOverdueKey=expiredKey.split(":");
            //System.out.println(beOverdueKey[1]+"/"+commands.keys("assignmentCache:"+beOverdueKey[1]+":*").size());
            updateCustomerServiceRedis(beOverdueKey[1]);
            sendInterruptMessage(beOverdueKey[2],beOverdueKey[1],"您与客服连接超时断开了");
            sendInterruptMessage(beOverdueKey[1],beOverdueKey[2],"因超时未通信连接已断开");
        }
    }

    /**
     * 发送连接超时中断消息
     */
    private void sendInterruptMessage(String receiveId,String authorId,String content){
        News news=new News();
        news.setOrderId("NULL");
        news.setAuthorId(authorId);
        news.setReceiveUserId(receiveId);
        news.setContent(content);
        news.setNewsType("0");
        webSocketHandler.receiveMessage(news);
    }

    /**
     * 更新客服的服务人数缓存记录
     * @param serviceId
     */
    private void updateCustomerServiceRedis(String serviceId){
        redisTemplate.opsForValue().set(webSocketHandler.CUSTOMER_SERVICE_RECEIPT_NUM_KEY+serviceId,
            new PersonnelAssignment(serviceId,commands.keys(webSocketHandler.ASSIGNMENT_CACHE_KEY+serviceId+":*").size()));
    }
}
