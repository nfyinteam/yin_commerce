package edu.nf.shopping.goods.dao;

import edu.nf.shopping.goods.entity.KeyRelation;

import java.util.List;

/**
 * @author Achine
 * @date 2020/3/31
 */
public interface KeyRelationDao {
    /**
     * 根据商品编号查询关键属性
     * @param goodId 商品编号
     * @return
     */
    List<KeyRelation> listKeyRelationByGoodsId(String goodId);
}
