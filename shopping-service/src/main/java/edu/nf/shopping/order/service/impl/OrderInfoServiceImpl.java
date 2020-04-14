package edu.nf.shopping.order.service.impl;

import edu.nf.shopping.order.dao.OrderDao;
import edu.nf.shopping.order.entity.OrderDetails;
import edu.nf.shopping.order.entity.OrderInfo;
import edu.nf.shopping.order.exception.OrderException;
import edu.nf.shopping.order.service.OrderDetailsService;
import edu.nf.shopping.order.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Achine
 * @date 2020/4/5
 */
@Service("orderInfoService")
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDetailsService detailsService;

    /**
     * 根据用户编号查询该用户所有订单信息
     * @param userId 用户编号
     * @return
     */
    @Override
    @Cacheable(value = "orderListCache", key = "#userId", condition = "#userId != null or #userId != ''")
    public List<OrderInfo> listOrderInfoByUserId(String userId) {
        try {
            if(userId.equals("") || userId == null){
                throw new OrderException("该用户不存在");
            }
            List<OrderInfo> list = orderDao.listOrderInfo(userId);
            if(list == null || list.size() == 0){
                throw new OrderException("该用户不存在");
            }
            return list;
        }catch (Exception e){
            throw new OrderException(e);
        }
    }

    /**
     * 根据订单编号查询订单信息
     * @param orderId 订单编号
     * @return
     */
    @Override
    @Cacheable(value = "orderCache", key = "#orderId", condition = "#orderId != null or #orderId != ''")
    public OrderInfo getOrderInfoByOrderId(String orderId) {
        try {
            if(orderId.equals("") || orderId == null){
                throw new OrderException("订单不能为空");
            }
            OrderInfo orderInfo = orderDao.getOrderInfoByOrderId(orderId);
            orderInfo.setOrderDetails(detailsService.listOrderDetailsByOrderId(orderId));
            if(orderInfo == null){
                throw new OrderException("该订单不存在");
            }
            return orderInfo;
        }catch (Exception e){
            throw new OrderException(e);
        }
    }

    /**
     * 修改订单
     * @param orderInfo 订单信息
     * @return
     */

    /**
     * 根据订单编号删除该订单
     * @param orderId 订单编号
     */
    @Override
    @CacheEvict(value = "orderCache", key = "#orderId")
    public void deleteOrderInfo(String orderId) {
        try{
            if (orderId == null || orderId.equals("")){
                throw new OrderException("订单编号不能为空");
            }
            orderDao.deleteOrderInfo(orderId);
        }catch (Exception e){
            throw new OrderException(e);
        }
    }


}
