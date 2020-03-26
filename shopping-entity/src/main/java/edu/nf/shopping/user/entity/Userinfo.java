package edu.nf.shopping.user.entity;



/**
 * @author re
 * @date 2020/3/22
 */
public class Userinfo {
    /**
     * 用户编号
     */
    private String uid;
    /**
     * 用户名称
     */
    private String uname;
    /**
     * 用户邮箱
     */
    private String uemail;
    /**
     * 用户手机号
     */
    private String utel;
    /**
     * 用户密码
     */
    private String upassword;
    /**
     * 用户性别
     */
    private String usex;
    /**
     * 用户真实姓名
     */
    private String realname;
    /**
     * 用户身份证号码
     */
    private String carnumber;
    /**
     * 用户头像编号
     */
    private String factid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }

    public String getFactid() {
        return factid;
    }

    public void setFactid(String factid) {
        this.factid = factid;
    }

}
