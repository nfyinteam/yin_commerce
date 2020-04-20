package edu.nf.shopping.comment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Bull fighters
 * @date 2020/4/2
 */
@Data
public class Examine {
    private String examineId;
    private String type;
    /**
     * 审核员编号
     */
    private String staffId;
    private String comId;
    /**
     * 审核结果
     */
    private String result;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    private String comUserId;
    private String reason;
}