package edu.nf.shopping.order.service;

import edu.nf.shopping.order.entity.OrderInfo;

import java.util.List;

/**
 * @author Achine
 * @date 2020/4/5
 */
public interface OrderInfoService {

    List<OrderInfo> listOrderInfoByUserId(String userId);

    OrderInfo getOrderInfoByOrderId(String orderId);

    void deleteOrderInfo(String orderId);

}