package edu.nf.shopping.message.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.nf.shopping.comment.entity.Comment;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/4/1
 */
@Data
public class Notice {
    private String noticeId;
    private String title;
    private String content;
    private String link;
    private String author;
    private String comId;
    private String type;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    private String state;
    private Comment comment;
    private String notView;
    private String newMessageNum;
    private String currentContent;
    private String parentContent;
    private String parentCid;
    private List<UserSetUp> userSetUpList;
}