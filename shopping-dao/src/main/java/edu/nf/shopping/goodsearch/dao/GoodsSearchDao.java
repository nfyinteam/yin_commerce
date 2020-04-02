package edu.nf.shopping.goodsearch.dao;

import edu.nf.shopping.goodsearch.entity.GoodsSearch;

import java.util.List;

/**
 * @author 彭哥
 * @date 2020/3/28
 */
public interface GoodsSearchDao {

    /**
     * 搜索
     * @param name
     * @return
     */
    List<GoodsSearch> listGoodsSearchByName(String name);
}
