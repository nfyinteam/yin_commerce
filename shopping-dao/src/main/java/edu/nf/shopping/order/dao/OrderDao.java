package edu.nf.shopping.order.dao;

import edu.nf.shopping.order.entity.OrderInfo;

import java.util.List;

/**
 * @author Achine
 * @date 2020/4/5
 */
public interface OrderDao {
    /**
     * 根据用户编号查询该用户所有订单
     * @param userId 用户编号
     * @return
     */
    List<OrderInfo> listOrderInfo(String userId);

    /**
     * 根据订单编号查询订单信息
     * @param orderId
     * @return
     */
    OrderInfo getOrderInfoByOrderId(String orderId);

    /**
     * 添加订单
     * @param orderInfo 订单信息
     */
    void addOrderInfo(OrderInfo orderInfo);

    /**
     * 修改订单
     * @param orderInfo 订单信息
     */
    void updateOrderInfo(OrderInfo orderInfo);

    /**
     * 删除订单
     * @param orderId 订单编号
     */
    void deleteOrderInfo(String orderId);
}