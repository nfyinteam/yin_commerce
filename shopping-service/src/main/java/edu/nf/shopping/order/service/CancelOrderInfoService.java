package edu.nf.shopping.order.service;

import edu.nf.shopping.order.entity.OrderInfo;

/**
 * @author Achine
 * @date 2020/4/14
 */
public interface CancelOrderInfoService {

    OrderInfo cancelOrderInfoService(String orderId);
}