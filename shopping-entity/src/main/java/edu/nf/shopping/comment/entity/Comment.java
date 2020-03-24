package edu.nf.shopping.comment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/12
 */
@Data
public class Comment {
    private String comId;
    private String goodsId;
    private String userId;
    private String parentId;
    private String bycId;
    private String content;
    private String comScore;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private String state;
    private String grade;
    private String byUserName;
    private String total;
    private String praiseNum;
    private String theUser;
    private String totalScore;
    private List<ImgInfo> imgInfoList;
    private List<Comment> commentList;
}