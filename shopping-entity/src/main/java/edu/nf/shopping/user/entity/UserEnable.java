package edu.nf.shopping.user.entity;

import java.util.Date;

/**
 * @author re
 * @date 2020/3/23
 */
public class UserEnable {
    /**
     * 封禁编号
     */
    private String eid;
    /**
     * 用户编号
     */
    private String uid;
    /**
     * 是否到期
     */
    private Integer isEnable;
    /**
     * 封禁时间
     */
    private Date joinTime;
    /**
     * 到期时间
     */
    private Date endTime;


    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


}
