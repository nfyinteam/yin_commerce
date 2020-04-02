package edu.nf.shopping.message.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Bull fighters
 * @date 2020/4/1
 */
@Data
public class News {
    private String newsId;
    private String contents;
    private String imgId;
    private String authorId;
    private String goodsId;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private Receive receive;
}