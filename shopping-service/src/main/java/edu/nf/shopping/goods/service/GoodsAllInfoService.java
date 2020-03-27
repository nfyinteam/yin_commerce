package edu.nf.shopping.goods.service;

import edu.nf.shopping.goods.entity.GoodsAllInfo;

import java.util.List;

/**
 * @author Achine
 * @date 2020/3/27
 */
public interface GoodsAllInfoService {
    /**
     * 根据商品编号查询所有信息
     * @param goodId 商品编号
     * @return
     */
    List<GoodsAllInfo> getGoodsInfoById(String goodId);
}