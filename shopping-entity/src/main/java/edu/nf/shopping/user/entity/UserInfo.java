package edu.nf.shopping.user.entity;



/**
 * @author re
 * @date 2020/3/22
 */
public class UserInfo {
    /**
     * 用户编号
     */
    private String uid;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户邮箱
     */
    private String userEmail;
    /**
     * 用户手机号
     */
    private String userTel;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 用户性别
     */
    private String userSex;
    /**
     * 用户真实姓名
     */
    private String realName;
    /**
     * 用户身份证号码
     */
    private String cardNum;
    /**
     * 用户头像编号
     */
    private UserFace userFace;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public UserFace getUserFace() {
        return userFace;
    }

    public void setUserFace(UserFace userFace) {
        this.userFace = userFace;
    }

}
