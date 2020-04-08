package edu.nf.shopping.order.service.impl;

import edu.nf.shopping.order.dao.OrderDao;
import edu.nf.shopping.order.entity.OrderInfo;
import edu.nf.shopping.order.service.DestroyOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Achine
 * @date 2020/4/8
 * 支付失败，销毁订单
 */
@Service("payDestroyOrderInfoService")
public class PayDestroyOrderInfoServiceImpl implements DestroyOrderInfoService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void destroyOrder(OrderInfo orderInfo) {

    }
}
