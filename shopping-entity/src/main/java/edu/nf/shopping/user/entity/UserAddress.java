package edu.nf.shopping.user.entity;

import edu.nf.shopping.warehouse.entity.City;

/**
 * @author re
 * @date 2020/3/23
 */
public class UserAddress {
    /**
     * 用户地址编号
     */
    private String addressId;
    /**
     * 用户编号
     */
    private String uid;
    /**
     * city表下的c_id
     */
    private City city;
    /**
     * 用户详细地址
     */
    private String addressName;
    /**
     * 是否为首用
     */
    private Integer isSel;

    private String addressTel;

    private String addressUser;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public Integer getIsSel() {
        return isSel;
    }

    public void setIsSel(Integer isSel) {
        this.isSel = isSel;
    }

    public String getAddressTel() {
        return addressTel;
    }

    public void setAddressTel(String addressTel) {
        this.addressTel = addressTel;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }
}
