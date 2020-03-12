package edu.nf.shopping.comment.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Bull fighters
 * @date 2020/3/12
 */
@Data
public class Comment {
    private String comId;
    private String goodsId;
    private String userId;
    private String byId;
    private String content;
    private Date time;
    private String state;
    private String grade;
}