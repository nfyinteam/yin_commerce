package edu.nf.shopping.goods.entity;

import java.util.List;
import java.util.Map;

/**
 * @author Achine
 * @date 2020/3/26
 */
public class GoodsAllInfo {
    private GoodsInfo goodsInfo;
    private List<GoodsImgs> goodsImgs;
    private List<SkuRelation> skuRelations;
    private List<IntroduceInfo> introduceInfos;
    private List<IntroduceType> introduceTypes;
    private Map<String, List<ValueInfo>> skuMap;
    private Map<String, List<IntroduceInfo>> introduceMap;
    private Map<String, List<KeyRelation>> keyRelationMap;

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

    public Map<String, List<ValueInfo>> getSkuMap() {
        return skuMap;
    }

    public void setSkuMap(Map<String, List<ValueInfo>> skuMap) {
        this.skuMap = skuMap;
    }

    public List<IntroduceType> getIntroduceTypes() {
        return introduceTypes;
    }

    public void setIntroduceTypes(List<IntroduceType> introduceTypes) {
        this.introduceTypes = introduceTypes;
    }

    public Map<String, List<IntroduceInfo>> getIntroduceMap() {
        return introduceMap;
    }

    public void setIntroduceMap(Map<String, List<IntroduceInfo>> introduceMap) {
        this.introduceMap = introduceMap;
    }

    public Map<String, List<KeyRelation>> getKeyRelationMap() {
        return keyRelationMap;
    }

    public void setKeyRelationMap(Map<String, List<KeyRelation>> keyRelationMap) {
        this.keyRelationMap = keyRelationMap;
    }
}
