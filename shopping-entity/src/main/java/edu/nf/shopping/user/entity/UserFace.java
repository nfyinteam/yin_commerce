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
    private String faceId;
    /**
     * 用户编号
     */
    private UserInfo user;
    /**
     * 头像文件全名
     */
    private String faceFile;
    /**
     * 保存头像时间
     */
    private Date joinDate;

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public String getFaceFile() {
        return faceFile;
    }

    public void setFaceFile(String faceFile) {
        this.faceFile = faceFile;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}
