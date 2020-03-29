package edu.nf.shopping.goods.entity;

/**
 * @author Achine
 * @date 2020/2/27
 */
public class SkuRelation {
    private KeyInfo key;
    private ValueInfo value;
    private SkuInfo skuInfo;

    public KeyInfo getKey() {
        return key;
    }

    public void setKey(KeyInfo key) {
        this.key = key;
    }

    public ValueInfo getValue() {
        return value;
    }

    public void setValue(ValueInfo value) {
        this.value = value;
    }

    public SkuInfo getSkuInfo() {
        return skuInfo;
    }

    public void setSkuInfo(SkuInfo skuInfo) {
        this.skuInfo = skuInfo;
    }
}
