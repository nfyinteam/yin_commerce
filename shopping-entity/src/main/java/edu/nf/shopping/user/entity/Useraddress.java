package edu.nf.shopping.user.entity;

/**
 * @author re
 * @date 2020/3/23
 */
public class Useraddress {
    /**
     * 用户地址编号
     */
    private String addressid;
    /**
     * 用户编号
     */
    private String uid;
    /**
     * city表下的c_id
     */
    private int addressregion;
    /**
     * 用户详细地址
     */
    private String addressname;
    /**
     * 是否为首用
     */
    private byte issel;

    public byte getIssel() {
        return issel;
    }

    public void setIssel(byte issel) {
        this.issel = issel;
    }

    public String getAddressid() {
        return addressid;
    }

    public void setAddressid(String addressid) {
        this.addressid = addressid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getAddressregion() {
        return addressregion;
    }

    public void setAddressregion(int addressregion) {
        this.addressregion = addressregion;
    }

    public String getAddressname() {
        return addressname;
    }

    public void setAddressname(String addressname) {
        this.addressname = addressname;
    }



}
