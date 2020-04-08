package edu.nf.shopping.order.service;

import edu.nf.shopping.order.entity.OrderInfo;

/**
 * @author Achine
 * @date 2020/4/8
 */
public interface DestroyOrderInfoService {

    void destroyOrder(OrderInfo orderInfo);
}