package edu.nf.shopping.order.entity;

import edu.nf.shopping.goods.entity.SkuInfo;

import java.math.BigDecimal;

/**
 * @author Achine
 * @date 2020/4/5
 * 订单明细表
 */
public class OrderDetails {

    /**
     * 订单编号
     */
    private String orderId;

    /**
     * 商品数量
     */
    private Integer skuNum;

    /**
     * 订单编号
     */
    private String skuId;

    /**
     * sku价格
     */
    private BigDecimal skuPrice;

    /**
     * sku属性
     */
    private String skuAttribute;

    /**
     * 商品编号
     */
    private String goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品图片
     */
    private String goodsFile;

    /**
     * 货物编号
     */
    private String cargoId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Integer getSkuNum() {
        return skuNum;
    }

    public void setSkuNum(Integer skuNum) {
        this.skuNum = skuNum;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(BigDecimal skuPrice) {
        this.skuPrice = skuPrice;
    }

    public String getSkuAttribute() {
        return skuAttribute;
    }

    public void setSkuAttribute(String skuAttribute) {
        this.skuAttribute = skuAttribute;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsFile() {
        return goodsFile;
    }

    public void setGoodsFile(String goodsFile) {
        this.goodsFile = goodsFile;
    }

    public String getCargoId() {
        return cargoId;
    }

    public void setCargoId(String cargoId) {
        this.cargoId = cargoId;
    }
}
