package edu.nf.shopping.goodsearch.service.impl;

import edu.nf.shopping.goodsearch.dao.GoodsSearchDao;
import edu.nf.shopping.goodsearch.service.GoodsSearchService;
import edu.nf.shopping.search.entity.GoodsSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 彭哥
 * @date 2020/3/28
 */
@Service("goodsSearchService")
public class GoodsSearchServiceImpl implements GoodsSearchService {


    @Autowired
    private GoodsSearchDao goodsSearchDao;
    /**
     * 搜索
     *
     * @param name
     * @return
     */
    @Override
    public List<GoodsSearch> listGoodsSearchByName(String name) {

        return goodsSearchDao.listGoodsSearchByName(name);
    }
}
