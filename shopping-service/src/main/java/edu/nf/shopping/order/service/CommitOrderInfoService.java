package edu.nf.shopping.order.service;

import edu.nf.shopping.order.entity.OrderInfo;

/**
 * @author Achine
 * @date 2020/4/9
 */
public interface CommitOrderInfoService {

    OrderInfo commitOrderInfo(String orderId, String buyRemark, String addressId);
}