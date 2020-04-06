package edu.nf.shopping.order.dao;

import edu.nf.shopping.order.entity.OrderDetails;

import java.util.List;

/**
 * @author Achine
 * @date 2020/4/6
 */
public interface OrderDetailsDao {

    /**
     * 根据订单编号查询所有订单明细信息
     * @param orderId 订单编号
     * @return
     */
    List<OrderDetails> listOrderDetailsByOrderId(String orderId);

    /**
     * 根据订单编号和sku编号查询订单明细信息
     * @param orderId 订单编号
     * @param skuId sku编号
     * @return
     */
    OrderDetails getOrderDetailsByOrderId(String orderId, String skuId);

    /**
     * 添加订单明细信息
     * @param orderDetails 订单明细信息
     */
    void addOrderDetails(List<OrderDetails> orderDetails);

    /**
     * 修改订单明细信息
     * @param orderDetails 订单明细信息
     */
    void updateOrderDetails(List<OrderDetails> orderDetails);

    /**
     * 删除订单明细信息
     * @param orderIds 订单编号数组
     */
    void deleteOrderDetails(String ... orderIds);
}