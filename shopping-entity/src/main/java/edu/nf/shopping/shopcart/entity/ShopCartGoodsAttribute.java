package edu.nf.shopping.shopcart.entity;

/**
 * 购物车商品属性实体类
 * @author Vera
 * @date 2020/3/27
 */
public class ShopCartGoodsAttribute {
    private Integer keyId;
    private String keyName;
    private String valueName;

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }
}
