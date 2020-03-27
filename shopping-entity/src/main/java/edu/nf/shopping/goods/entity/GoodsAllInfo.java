package edu.nf.shopping.goods.entity;

import java.util.List;

/**
 * @author Achine
 * @date 2020/3/26
 */
public class GoodsAllInfo {
    private GoodsInfo goodsInfo;
    private List<GoodsImgs> goodsImgs;
    private List<SkuRelation> skuRelations;
    private List<IntroduceInfo> introduceInfos;

    public GoodsInfo getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public List<GoodsImgs> getGoodsImgs() {
        return goodsImgs;
    }

    public void setGoodsImgs(List<GoodsImgs> goodsImgs) {
        this.goodsImgs = goodsImgs;
    }

    public List<SkuRelation> getSkuRelations() {
        return skuRelations;
    }

    public void setSkuRelations(List<SkuRelation> skuRelations) {
        this.skuRelations = skuRelations;
    }

    public List<IntroduceInfo> getIntroduceInfos() {
        return introduceInfos;
    }

    public void setIntroduceInfos(List<IntroduceInfo> introduceInfos) {
        this.introduceInfos = introduceInfos;
    }
}
