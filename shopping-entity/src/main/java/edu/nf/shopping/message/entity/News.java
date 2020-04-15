package edu.nf.shopping.message.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Date;

/**
 * @author Bull fighters
 * @date 2020/4/1
 */
@Data
public class News {
    private String newsId;
    private String content;
    private String imgName;
    private String authorId;
    private String orderId;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private String notView;
    private String receiveUserId;
    private String newsType;
    private String customerService;
    private String userId;
    private String total;
    private String state;
}