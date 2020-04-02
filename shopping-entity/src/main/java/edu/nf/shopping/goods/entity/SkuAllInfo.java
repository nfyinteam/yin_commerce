package edu.nf.shopping.goods.entity;

import java.util.List;

/**
 * @author Achine
 * @date 2020/4/2
 */
public class SkuAllInfo {
    private SkuInfo skuInfo;
    private List<SkuRelation> skuRelations;

    public SkuInfo getSkuInfo() {
        return skuInfo;
    }

    public void setSkuInfo(SkuInfo skuInfo) {
        this.skuInfo = skuInfo;
    }

    public List<SkuRelation> getSkuRelations() {
        return skuRelations;
    }

    public void setSkuRelations(List<SkuRelation> skuRelations) {
        this.skuRelations = skuRelations;
    }
}
