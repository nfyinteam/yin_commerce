package edu.nf.shopping.order.service.impl;

import edu.nf.shopping.order.dao.OrderDao;
import edu.nf.shopping.order.dao.OrderDetailsDao;
import edu.nf.shopping.order.entity.OrderInfo;
import edu.nf.shopping.order.exception.OrderException;
import edu.nf.shopping.order.service.DelOrderInfoService;
import edu.nf.shopping.order.service.DestroyOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

/**
 * @author Achine
 * @date 2020/4/14
 */
@Service("delOrderInfoService")
public class DelOrderInfoServiceImpl implements DelOrderInfoService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDetailsDao detailsDao;

    @Qualifier("destroyOrderInfoService")
    private DestroyOrderInfoService destroyOrderInfoService;

    @Override
    @CacheEvict(value = "orderCache", key = "#orderId", beforeInvocation = true)
    public void delOrderInfo(String orderId) {
        try {
            if(orderId == null || orderId.equals("")){
                throw new OrderException("订单编号不能为空");
            }
            OrderInfo order = orderDao.getOrderInfoByOrderId(orderId);
            if(order == null){
                throw new OrderException("该订单不存在");
            }
            order.setOrderDetails(detailsDao.listOrderDetailsByOrderId(orderId));
            if(order.getOrderState().equals("确认中") || order.getOrderState().equals("待付款")){
                destroyOrderInfoService.destroyOrder(order);
            }
            order.setDel(false);
            orderDao.updateOrderInfo(order);
        }catch (Exception e){
            throw new OrderException(e);
        }
    }
}
