package edu.nf.shopping.goods_search.service.impl;

import edu.nf.shopping.goods_search.dao.GoodsSearchDao;
import edu.nf.shopping.goods_search.entity.GoodsInfo;
import edu.nf.shopping.goods_search.service.GoodsSearchService;
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
    public List<GoodsInfo> listGoodsSearchByName(String name) {

        return goodsSearchDao.listGoodsSearchByName(name);
    }
}
