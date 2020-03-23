package edu.nf.shopping.goods.dao;

import edu.nf.shopping.goods.entity.KeyInfo;
import edu.nf.shopping.goods.entity.SkuRelation;

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
     * 根据商品编号查询该商品有的Key
     * @param goodsId 商品编号
     * @return
     */
    List<KeyInfo> listKeyInfoByGoodsId(String goodsId);


}