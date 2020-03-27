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
    private byte isenable;
    /**
     * 封禁时间
     */
    private Date jointime;
    /**
     * 到期时间
     */
    private Date endtime;
    /**
     * 封号理由
     */
    private String remarks;
    /**
     * 审核编号
     */
    private String eeid;

    public String getEeid() {
        return eeid;
    }

    public void setEeid(String eeid) {
        this.eeid = eeid;
    }

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

    public byte getIsenable() {
        return isenable;
    }

    public void setIsenable(byte isenable) {
        this.isenable = isenable;
    }

    public Date getJointime() {
        return jointime;
    }

    public void setJointime(Date jointime) {
        this.jointime = jointime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


}
