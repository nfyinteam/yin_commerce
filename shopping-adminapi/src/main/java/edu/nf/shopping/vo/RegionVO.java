package edu.nf.shopping.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import java.util.Date;
/**
 * @author Bull fighters
 * @date 2020/3/26
 */
@Data
public class RegionVO {
    private String prId;
    private String index;
    private String info;

}