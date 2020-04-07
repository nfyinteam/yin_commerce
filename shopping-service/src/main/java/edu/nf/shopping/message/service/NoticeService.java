package edu.nf.shopping.message.service;

import com.github.pagehelper.PageInfo;
import edu.nf.shopping.message.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/4/4
 */
public interface NoticeService {


    /**
     * 用户查看回复通知
     **/
    List<Notice> userListNotice(String noticeType,String userId);

    List<Notice> listNotViewByUserId(String userId);



    int addNotice(Notice notice);

}