package edu.nf.shopping.goodsearch.service;

import edu.nf.shopping.goodsearch.entity.GoodsSearch;

import java.util.List;

/**
 * @author 彭哥
 * @date 2020/3/28
 */
public interface GoodsSearchService {

    /**
     * 搜索
     * @param name
     * @return
     */
    List<GoodsSearch> listGoodsSearchByName(String name);
}
