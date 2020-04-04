package edu.nf.shopping.search.entity;

import java.math.BigDecimal;

/**
 * @author 彭哥
 * @date 2020/4/2
 */
public class GoodsSearch {
    private String goodsName;
    private BigDecimal skuPrice;
    private String imgFile;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(BigDecimal skuPrice) {
        this.skuPrice = skuPrice;
    }

    public String getImgFile() {
        return imgFile;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }
}
