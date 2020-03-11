package edu.nf.shopping.order.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lishun
 * @date 2020/3/11
 * 订单信息表
 */
public class OrderInfo {
    /**
     * 时间戳、主键
     */
    private String orderId;
    /**
     * 购买价格
     */
    private BigDecimal buyPrice;
    /**
     * 购买优惠
     */
    private BigDecimal cheapPrice;
    /**
     * 运送费用
     */
    private BigDecimal transportPrice;
    /**
     * 购买时间
     */
    private Date buyTime;
    /**
     * 客服人员编号
     */
    private String buyAdmin;
    /**
     * 用户编号
     */
    private String buyUser;
    /**
     * 收货地区
     */
    private String collectRegion;
    /**
     * 收货详细地址
     */
    private String collectAddress;
    /**
     * 买家备注
     */
    private String buyRemark;
    /**
     * 订单备注
     */
    private String orderRemark;
    /**
     * 订单状态编号
     */
    private Integer osId;
    /**
     * 关联订单编号表
     */
    private OrderState orderState;

    public OrderInfo(String orderId, BigDecimal buyPrice, BigDecimal cheapPrice, BigDecimal transportPrice, Date buyTime, String buyAdmin, String buyUser, String collectRegion, String collectAddress, String buyRemark, String orderRemark, Integer osId, OrderState orderState) {
        this.orderId = orderId;
        this.buyPrice = buyPrice;
        this.cheapPrice = cheapPrice;
        this.transportPrice = transportPrice;
        this.buyTime = buyTime;
        this.buyAdmin = buyAdmin;
        this.buyUser = buyUser;
        this.collectRegion = collectRegion;
        this.collectAddress = collectAddress;
        this.buyRemark = buyRemark;
        this.orderRemark = orderRemark;
        this.osId = osId;
        this.orderState = orderState;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getCheapPrice() {
        return cheapPrice;
    }

    public void setCheapPrice(BigDecimal cheapPrice) {
        this.cheapPrice = cheapPrice;
    }

    public BigDecimal getTransportPrice() {
        return transportPrice;
    }

    public void setTransportPrice(BigDecimal transportPrice) {
        this.transportPrice = transportPrice;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public String getBuyAdmin() {
        return buyAdmin;
    }

    public void setBuyAdmin(String buyAdmin) {
        this.buyAdmin = buyAdmin;
    }

    public String getBuyUser() {
        return buyUser;
    }

    public void setBuyUser(String buyUser) {
        this.buyUser = buyUser;
    }

    public String getCollectRegion() {
        return collectRegion;
    }

    public void setCollectRegion(String collectRegion) {
        this.collectRegion = collectRegion;
    }

    public String getCollectAddress() {
        return collectAddress;
    }

    public void setCollectAddress(String collectAddress) {
        this.collectAddress = collectAddress;
    }

    public String getBuyRemark() {
        return buyRemark;
    }

    public void setBuyRemark(String buyRemark) {
        this.buyRemark = buyRemark;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public Integer getOsId() {
        return osId;
    }

    public void setOsId(Integer osId) {
        this.osId = osId;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public OrderInfo() {
    }
}
