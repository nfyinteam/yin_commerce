package edu.nf.shopping.goods.dao;

import edu.nf.shopping.goods.entity.KeyInfo;
import edu.nf.shopping.goods.entity.SkuRelation;
import edu.nf.shopping.goods.entity.ValueInfo;

import java.util.List;

/**
 * @author Achine
 * @date 2020/3/18
 */
public interface SkuRelationDao {

    /**
     * 根据商品编号查询Sku关联信息
     * @param goodsId 商品编号
     * @return
     */
    List<SkuRelation> listSkuRelationByGoodsId(String goodsId);

    /**
     * 根据SKU编号查询Sku关联信息
     * @param skuId SKU编号
     * @return
     */
    List<SkuRelation> listSkuRelationBySkuId(String skuId);

    /**
     * 根据商品编号查询该商品有的Key
     * @param goodsId 商品编号
     * @return
     */
    List<KeyInfo> listKeyInfoByGoodsId(String goodsId);

    /**
     * 根据商品编号和Key编号查询所有value
     * @param goodsId 商品编号
     * @param keyId Key编号
     * @return
     */
    List<ValueInfo> listValueInfoByGoodsIdAndKeyId(String goodsId, String keyId);

    /**
     * 添加Sku关联信息
     * @param skuRelation
     */
    void addSkuRelation(SkuRelation skuRelation);

    /**
     * 修改Sku关联信息
     * @param skuRelation
     */
    void updetaSkuRelation(SkuRelation skuRelation);

    /**
     * 删除Sku关联信息
     * @param skuRelation
     */
    void deleteSkuRelation(SkuRelation skuRelation);
}