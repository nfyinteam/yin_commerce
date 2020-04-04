package edu.nf.shopping.page.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Bull fighters
 * @date 2020/3/27
 */
@Data
public class PageRegion {
    private String prId ;
    private String sign;
    private String index;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startTime;
    private String state;
    private List<RegionContent> infoList=new ArrayList<>();
}