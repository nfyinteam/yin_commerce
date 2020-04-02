package edu.nf.shopping.goods.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author Achine
 * @date 2020/2/26
 */
public class SpuInfo {
    private String spuId;
    private String spuName;
    private String spuRemark;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date listTime;
    private Integer spuNum;

    public String getSpuId() {
        return spuId;
    }

    public void setSpuId(String spuId) {
        this.spuId = spuId;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public String getSpuRemark() {
        return spuRemark;
    }

    public void setSpuRemark(String spuRemark) {
        this.spuRemark = spuRemark;
    }

    public Date getListTime() {
        return listTime;
    }

    public void setListTime(Date listTime) {
        this.listTime = listTime;
    }

    public Integer getSpuNum() {
        return spuNum;
    }

    public void setSpuNum(Integer spuNum) {
        this.spuNum = spuNum;
    }

}
