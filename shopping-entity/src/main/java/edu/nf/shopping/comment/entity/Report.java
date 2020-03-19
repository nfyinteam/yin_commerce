package edu.nf.shopping.comment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Bull fighters
 * @date 2020/3/19
 */
@Data
public class Report {
    private String reportId;
    private String wtbId;
    private String comId;
    private String reason;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String time;
    private String state;
}