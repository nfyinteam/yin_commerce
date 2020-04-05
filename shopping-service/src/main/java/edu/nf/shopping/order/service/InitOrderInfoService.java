package edu.nf.shopping.order.service;

import edu.nf.shopping.order.entity.OrderDetails;
import edu.nf.shopping.order.entity.OrderInfo;

import java.util.List;

/**
 * @author Achine
 * @date 2020/4/5
 */
public interface InitOrderInfoService {

    OrderInfo initOrderInfo(String userId);

}