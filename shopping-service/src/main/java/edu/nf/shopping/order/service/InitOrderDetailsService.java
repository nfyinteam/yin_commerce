package edu.nf.shopping.order.service;

import edu.nf.shopping.order.entity.OrderDetails;

import java.util.List;

/**
 * @author Achine
 * @date 2020/4/6
 */
public interface InitOrderDetailsService {

    void initOrderDetails(List<OrderDetails> orderDetails);
}