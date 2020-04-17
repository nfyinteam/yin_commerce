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
        try {
            List<GoodsInfo> list = dao.listGoods();
            return list;
        }catch (Exception e){
            throw new GoodsException(e);
        }
    }

    @Override
    public List<GoodsInfo> listGoodsByName(String name) {
        try {
            List<GoodsInfo> list = dao.listGoodsByName(name);
            if(list == null || list.size() == 0){
                throw new GoodsException("没有该商品");
            }
            return list;
        }catch (Exception e){
            throw new GoodsException(e);
        }
    }

    @Override
    public List<GoodsInfo> listGoodsBySpuId(String spuId) {
        try {
            List<GoodsInfo> list = dao.listGoodsBySpuId(spuId);
            if(list == null || list.size() == 0){
                throw new GoodsException("该产品没有商品");
            }
            return list;
        }catch (Exception e){
            throw new GoodsException(e);
        }
    }

    @Override
    public GoodsInfo getGoodsById(String id) {
        try {
            GoodsInfo goods = dao.getGoodsById(id);
            if(goods == null){
                throw new GoodsException("该商品不存在");
            }
            return goods;
        }catch (Exception e){
            throw new GoodsException(e);
        }
    }
}
