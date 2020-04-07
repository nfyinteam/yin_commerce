package edu.nf.shopping.message.dao;

import edu.nf.shopping.message.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/4/1
 */
public interface NoticeDao {

    /**
     * 根据类型查询通知
     * @param type
     * @param userId
     * @return
     */
    List<Notice> userListNotice(String type,String userId);

    /**
     * 查询用户未读通知数量
     * @param userId
     * @return
     */
    List<Notice> listNotViewByUserId(String userId);



    /**
     * 添加通知
     * @param notice
     * @return
     */
    int addNotice(Notice notice);

}