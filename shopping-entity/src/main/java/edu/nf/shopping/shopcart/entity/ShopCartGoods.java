package edu.nf.shopping.shopcart.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 购物车商品实体类
 * @author Vera
 * @date 2020/3/27
 */
public class ShopCartGoods {
    private String scId;
    private String imgFile;
    private String goodsName;
    private String skuId;
    private BigDecimal skuPrice;
    private Integer skuStock;
    private Date joinTime;
    private List<ShopCartGoodsAttribute> scga;

    public String getScId() {
        return scId;
    }

    public void setScId(String scId) {
        this.scId = scId;
    }

    public String getImgFile() {
        return imgFile;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public BigDecimal getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(BigDecimal skuPrice) {
        this.skuPrice = skuPrice;
    }

    public Integer getSkuStock() {
        return skuStock;
    }

    public void setSkuStock(Integer skuStock) {
        this.skuStock = skuStock;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public List<ShopCartGoodsAttribute> getScga() {
        return scga;
    }

    public void setScga(List<ShopCartGoodsAttribute> scga) {
        this.scga = scga;
    }
}
