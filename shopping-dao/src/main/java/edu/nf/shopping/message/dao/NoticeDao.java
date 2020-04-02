package edu.nf.shopping.message.dao;

import edu.nf.shopping.message.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/4/1
 */
public interface NoticeDao {

    List<Notice> listNotice(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, String userId, String type);

    void addNotice(Notice notice);

}