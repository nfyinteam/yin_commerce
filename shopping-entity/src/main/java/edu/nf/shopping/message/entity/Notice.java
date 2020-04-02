package edu.nf.shopping.message.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String type;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String time;
}