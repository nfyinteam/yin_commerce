package edu.nf.shopping.message.service;

import com.rabbitmq.client.Channel;
import edu.nf.shopping.message.entity.News;
import edu.nf.shopping.message.entity.Receive;
import edu.nf.shopping.user.entity.UserInfo;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author Bull fighters
 * @date 2020/4/6
 */
public interface NewsService {

    /**
     * 查询用户单个的聊天记录
     * @param pageStart
     * @param pageSize
     * @param userId
     * @param order
     * @return
     */
    List<News> listUserNews(Integer pageStart, Integer pageSize, String userId,String authorId, String order);


    /**
     * 添加消息
     * @param news
     */
    News addNews(MultipartFile file,News news,String customerService,String userId,String routerKey);

    /**
     * 修改消息的状态
     */
    void updateNewsState(String authorId, String userId,String orderId);

    /**
     * 查询用户单个客服未读消息数量
     */
    List<News> findSingleNotView(String userId);

    /**
     * 获取客服列表
     */
    List<UserInfo> getUserNewsListByUserId(String userId,String customerService);

    void sendNews(News news);
}