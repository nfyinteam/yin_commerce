package edu.nf.shopping.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.nf.shopping.admin.entity.StaffInfo;
import edu.nf.shopping.user.entity.UserAddress;
import edu.nf.shopping.user.entity.UserInfo;
import edu.nf.shopping.warehouse.entity.CargoInfo;
import edu.nf.shopping.warehouse.entity.City;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Achine
 * @date 2020/4/5
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
     * 订单创建时间
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 支付时间
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date payTime;
    /**
     * 发货时间
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deliverTime;
    /**
     * 成交时间
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dealTime;
    /**
     * 客服人员
     */
    private StaffInfo buyAdmin;
    /**
     * 用户
     */
    private UserInfo buyUser;
    /**
     * 收货地址
     */
    private UserAddress userAddress;
    /**
     * 买家备注
     */
    private String buyRemark;
    /**
     * 订单备注
     */
    private String orderRemark;
    /**
     * 订单状态
     */
    private String orderState;
    /**
     * 用户地址区域
     */
    private City addressRegion;
    /**
     * 用户详细地址
     */
    private String addressName;
    /**
     * 签收号码
     */
    private String addressTel;
    /**
     * 签收人
     */
    private String addressUser;
    /**
     * 是否删除
     */
    private Boolean isDel;

    /**
     * 订单明细信息集合
     */
    private List<OrderDetails> orderDetails;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public StaffInfo getBuyAdmin() {
        return buyAdmin;
    }

    public void setBuyAdmin(StaffInfo buyAdmin) {
        this.buyAdmin = buyAdmin;
    }

    public UserInfo getBuyUser() {
        return buyUser;
    }

    public void setBuyUser(UserInfo buyUser) {
        this.buyUser = buyUser;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
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

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public City getAddressRegion() {
        return addressRegion;
    }

    public void setAddressRegion(City addressRegion) {
        this.addressRegion = addressRegion;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
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

    public Boolean getDel() {
        return isDel;
    }

    public void setDel(Boolean del) {
        isDel = del;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
