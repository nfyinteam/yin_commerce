package edu.nf.shopping.order.service.impl;

import edu.nf.shopping.goods.dao.SkuInfoDao;
import edu.nf.shopping.goods.entity.SkuInfo;
import edu.nf.shopping.goods.exception.SkuInfoException;
import edu.nf.shopping.order.dao.OrderDao;
import edu.nf.shopping.order.dao.OrderDetailsDao;
import edu.nf.shopping.order.entity.OrderDetails;
import edu.nf.shopping.order.entity.OrderInfo;
import edu.nf.shopping.order.exception.OrderDetailsException;
import edu.nf.shopping.order.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Achine
 * @date 2020/4/6
 */
public class OrderDetailsServiceImpl implements OrderDetailsService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @Autowired
    private SkuInfoDao skuInfoDao;

    /**
     * 根据订单编号查询所有订单明细信息
     * @param orderId 订单编号
     * @return
     */
    @Override
    public List<OrderDetails> listOrderDetailsByOrderId(String orderId) {
        try {
            if(orderId == null || orderId == ""){
                throw new OrderDetailsException("订单编号不能为空");
            }
            OrderInfo orderInfo = orderDao.getOrderInfoByOrderId(orderId);
            if(orderInfo == null){
                throw new OrderDetailsException("该订单不存在");
            }
            return orderDetailsDao.listOrderDetailsByOrderId(orderId);
        }catch (Exception e){
            throw new OrderDetailsException(e);
        }
    }

    /**
     * 根据订单编号和sku编号查询该订单明细信息
     * @param orderId 订单编号
     * @param skuId sku编号
     * @return
     */
    @Override
    public OrderDetails getOrederDetails(String orderId, String skuId) {
        try {
            if(orderId == null || orderId == ""){
                throw new OrderDetailsException("订单编号不能为空");
            }
            if(skuId == null || skuId == ""){
                throw new SkuInfoException("sku编号不能为空");
            }
            OrderInfo orderInfo = orderDao.getOrderInfoByOrderId(orderId);
            if(orderInfo == null){
                throw new OrderDetailsException("该订单不存在");
            }
            SkuInfo skuInfo = skuInfoDao.getSkuInfoBySkuId(skuId);
            if(skuInfo == null){
                throw new SkuInfoException("sku信息不存在");
            }
            return orderDetailsDao.getOrderDetailsByOrderId(orderId, skuId);
        }catch (Exception e){
            throw new OrderDetailsException(e);
        }
    }
}
