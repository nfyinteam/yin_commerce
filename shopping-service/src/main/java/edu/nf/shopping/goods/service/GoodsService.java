package edu.nf.shopping.goods.service;

import edu.nf.shopping.goods.entity.GoodsInfo;

import java.util.List;

/**
 * @author Achine
 * @date 2020/3/9
 */
public interface GoodsService {
    /**
     * 查询所有商品
     * @return
     */
    List<GoodsInfo> listGoods();

    /**
     * 根据名称查询所有商品
     * @return
     */
    List<GoodsInfo> listGoodsByName(String name);

    /**
     * 根据产品编号查询所有商品
     * @return
     */
    List<GoodsInfo> listGoodsBySpuId(String spuId);

    /**
     * 根据编号查询商品
     * @return
     */
    GoodsInfo listGoodsById(String id);
}
