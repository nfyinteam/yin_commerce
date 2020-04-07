package edu.nf.shopping.message.service;

import edu.nf.shopping.message.entity.News;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/4/6
 */
public interface NewsService {

    /**
     * 查询用户单个的聊天记录
     * @param pageNum
     * @param pageSize
     * @param userId
     * @param goodsId
     * @return
     */
    List<News> listUserNews(Integer pageNum, Integer pageSize, String userId, String goodsId);


    /**
     * 添加消息
     * @param news
     */
    void addNews(News news);
}