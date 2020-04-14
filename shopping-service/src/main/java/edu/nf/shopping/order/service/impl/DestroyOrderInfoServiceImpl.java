package edu.nf.shopping.order.service.impl;

import edu.nf.shopping.goods.entity.SkuInfo;
import edu.nf.shopping.goods.service.SkuInfoService;
import edu.nf.shopping.order.dao.OrderDao;
import edu.nf.shopping.order.dao.OrderDetailsDao;
import edu.nf.shopping.order.entity.OrderDetails;
import edu.nf.shopping.order.entity.OrderInfo;
import edu.nf.shopping.order.exception.OrderException;
import edu.nf.shopping.order.service.DestroyOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

/**
 * @author Achine
 * @date 2020/4/14
 */
@Service("destroyOrderInfoService")
public class DestroyOrderInfoServiceImpl implements DestroyOrderInfoService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private SkuInfoService skuInfoService;


    @Override
    @CacheEvict(value = "orderCache", key = "#orderInfo.orderId", beforeInvocation = true)
    public void destroyOrder(OrderInfo orderInfo) {
        try {
            OrderInfo o = orderDao.getOrderInfoByOrderId(orderInfo.getOrderId());
            if(o != null){
                //恢复库存
                for(OrderDetails details : orderInfo.getOrderDetails()){
                    SkuInfo skuInfo = skuInfoService.getSkuAllInfoBySkuId(details.getSkuId()).getSkuInfo();
                    skuInfo.setSkuStock(skuInfo.getSkuStock() + details.getSkuNum());
                    skuInfoService.updateSkuInfo(skuInfo);
                }
            }
        }catch (Exception e){
            throw new OrderException(e);
        }
    }
}
