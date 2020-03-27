package edu.nf.shopping.user.entity;

import java.util.Date;

/**
 * @author re
 * @date 2020/3/23
 */
public class UserFace {
    /**
     * 用户头像编号
     */
    private String faceid;
    /**
     * 用户编号
     */
    private String uid;
    /**
     * 头像文件全名
     */
    private String facefile;
    /**
     * 保存头像时间
     */
    private Date jiondate;
    public String getFaceid() {
        return faceid;
    }

    public void setFaceid(String faceid) {
        this.faceid = faceid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFacefile() {
        return facefile;
    }

    public void setFacefile(String facefile) {
        this.facefile = facefile;
    }

    public Date getJiondate() {
        return jiondate;
    }

    public void setJiondate(Date jiondate) {
        this.jiondate = jiondate;
    }

}
