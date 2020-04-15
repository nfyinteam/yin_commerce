package edu.nf.shopping.message.dao;

import edu.nf.shopping.message.entity.News;
import edu.nf.shopping.message.entity.Receive;

/**
 * @author Bull fighters
 * @date 2020/4/1
 */
public interface ReceiveDao {

    /**
     * 添加接收者
     * @param receive
     */
    void addReceive(Receive receive);

    /**
     * 根据消息编号修改状态
     */
    void updateNewsState(String newsId,String orderId, String userId);

    /**
     * 根据通知类型修改通知状态
     * @param noticeType
     * @param userId
     */
    void updateNoticeState(String noticeType,String userId);
}