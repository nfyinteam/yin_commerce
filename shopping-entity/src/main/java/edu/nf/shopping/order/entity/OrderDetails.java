package edu.nf.shopping.order.entity;

import edu.nf.shopping.goods.entity.SkuInfo;

/**
 * @author Achine
 * @date 2020/4/5
 * 订单明细表
 */
public class OrderDetails {

    /**
     * 订单编号
     */
    private OrderInfo orderInfo;

    /**
     * sku编号
     */
    private SkuInfo skuInfo;

    /**
     * 商品数量
     */
    private Integer skuNum;

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public SkuInfo getSkuInfo() {
        return skuInfo;
    }

    public void setSkuInfo(SkuInfo skuInfo) {
        this.skuInfo = skuInfo;
    }

    public Integer getSkuNum() {
        return skuNum;
    }

    public void setSkuNum(Integer skuNum) {
        this.skuNum = skuNum;
    }
}
