package edu.nf.shopping.goods.service.impl;

import edu.nf.shopping.goods.dao.GoodsDao;
import edu.nf.shopping.goods.entity.GoodsInfo;
import edu.nf.shopping.goods.exception.GoodsException;
import edu.nf.shopping.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Achine
 * @date 2020/3/9
 */
@Service("goodsService")
@Transactional(rollbackFor = GoodsException.class)
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao dao;

    @Override
    public List<GoodsInfo> listGoods() {
        return dao.listGoods();
    }

    @Override
    public List<GoodsInfo> listGoodsByName(String name) {
        return null;
    }

    @Override
    public List<GoodsInfo> listGoodsBySpuId(String spuId) {
        return null;
    }

    @Override
    public GoodsInfo listGoodsById(String id) {
        return null;
    }
}
