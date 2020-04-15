package edu.nf.shopping.message.dao;

import edu.nf.shopping.message.entity.News;
import edu.nf.shopping.message.entity.Notice;
import edu.nf.shopping.user.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/4/1
 */
public interface NewsDao {

    /**
     * 查询用户单个的聊天记录
     * @param pageStart
     * @param pageSize
     * @param userId
     * @param order
     * @return
     */
    List<News> listUserNews(Integer pageStart,Integer pageSize, String userId, String order);

    /**
     * 查询用户未读消息的数量
     * @param userId
     * @return
     */
    String findNotViewByUserId(String userId);

    /**
     * 添加消息
     * @param news
     */
    void addNews(News news);

    /**
     * 获取客服列表
     */
    List<UserInfo> getUserNewsListByUserId(String userId,String customerService);
}