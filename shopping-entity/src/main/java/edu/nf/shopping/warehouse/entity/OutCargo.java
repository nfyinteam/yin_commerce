package edu.nf.shopping.warehouse.entity;

import edu.nf.shopping.order.entity.OrderInfo;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lishun
 * @date 2020/3/11
 * 货物出库表
 */
public class OutCargo {
    /**
     * 主键
     */
    private  String outId;
    /**
     * 货物编号
     */
    private String cargoId;
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 出库时间
     */
    private Date outTime;
    /**
     * 出库人员
     */
    private String  outAdmin;
    /**
     * 关联订单表
     */
    private OrderInfo orderInfo;

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getCargoId() {
        return cargoId;
    }

    public void setCargoId(String cargoId) {
        this.cargoId = cargoId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getOutAdmin() {
        return outAdmin;
    }

    public void setOutAdmin(String outAdmin) {
        this.outAdmin = outAdmin;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public OutCargo(String outId, String cargoId, String orderId, Date outTime, String outAdmin, OrderInfo orderInfo) {
        this.outId = outId;
        this.cargoId = cargoId;
        this.orderId = orderId;
        this.outTime = outTime;
        this.outAdmin = outAdmin;
        this.orderInfo = orderInfo;
    }

    public OutCargo() {
    }
}
