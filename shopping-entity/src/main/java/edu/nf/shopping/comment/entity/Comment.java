package edu.nf.shopping.comment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date time;
    private String state;
    private String grade;
}