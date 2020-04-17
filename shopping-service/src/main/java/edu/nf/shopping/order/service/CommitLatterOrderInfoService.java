package edu.nf.shopping.order.service;

import edu.nf.shopping.order.entity.OrderInfo;

/**
 * @author Achine
 * @date 2020/4/5
 */
public interface CommitLatterOrderInfoService {

    OrderInfo updateOrderInfo(OrderInfo orderInfo);
}