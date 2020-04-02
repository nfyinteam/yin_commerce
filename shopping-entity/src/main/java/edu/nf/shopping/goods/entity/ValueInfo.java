package edu.nf.shopping.goods.entity;

/**
 * @author Achine
 * @date 2020/2/27
 */
public class ValueInfo {
    private Integer valueId;
    private String valueName;
    private KeyInfo keyInfo;
    /**
     * 给商品页面用
     */
    private SkuInfo skuInfo;

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public KeyInfo getKeyInfo() {
        return keyInfo;
    }

    public void setKeyInfo(KeyInfo keyInfo) {
        this.keyInfo = keyInfo;
    }

    public SkuInfo getSkuInfo() {
        return skuInfo;
    }

    public void setSkuInfo(SkuInfo skuInfo) {
        this.skuInfo = skuInfo;
    }
}
