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
            if(name == null || name == ""){
                throw new GoodsException("商品名称不能为空");
            }
            List<GoodsInfo> list = dao.listGoodsByName(name);
            return list;
        }catch (Exception e){
            throw new GoodsException(e);
        }
    }

    @Override
    public List<GoodsInfo> listGoodsBySpuId(String spuId) {
        try {
            if(spuId == null || spuId == ""){
                throw new GoodsException("SPU编号不能为空");
            }
            List<GoodsInfo> list = dao.listGoodsBySpuId(spuId);
            return list;
        }catch (Exception e){
            throw new GoodsException(e);
        }
    }

    @Override
    public GoodsInfo getGoodsById(String id) {
        try {
            if(id == null || id == ""){
                throw new GoodsException("商品编号不能为空");
            }
            GoodsInfo goods = dao.getGoodsById(id);
            return goods;
        }catch (Exception e){
            throw new GoodsException(e);
        }
    }
}
