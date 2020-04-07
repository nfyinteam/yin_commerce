package edu.nf.shopping.order.service.impl;

import edu.nf.shopping.order.dao.OrderDao;
import edu.nf.shopping.order.dao.OrderDetailsDao;
import edu.nf.shopping.order.entity.OrderDetails;
import edu.nf.shopping.order.entity.OrderInfo;
import edu.nf.shopping.order.exception.OrderException;
import edu.nf.shopping.order.service.UpdateOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Achine
 * @date 2020/4/5
 */
@Service("updateOrderInfoService")
public class UpdateOrderInfoServiceImpl implements UpdateOrderInfoService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDetailsDao detailsDao;

    /**
     * 修改订单状态
     * @param orderId 订单编号
     * @param state 订单状态
     * @return
     */
    @Override
    @Transactional(rollbackFor = {OrderException.class})
    public OrderInfo updateOrderInfoToState(String orderId, String state) {
        try {
            if(orderId == null || orderId == ""){
                throw new OrderException("该订单编号不能为空");
            }
            OrderInfo orderInfo = orderDao.getOrderInfoByOrderId(orderId);
            if(orderInfo == null){
                throw new OrderException("该订单不存在");
            }
            orderInfo.setOrderState(state);
            orderDao.updateOrderInfo(orderInfo);
            orderInfo.setOrderDetails(detailsDao.listOrderDetailsByOrderId(orderInfo.getOrderId()));
            return orderInfo;
        }catch (Exception e){
            throw new OrderException(e);
        }
    }
}
