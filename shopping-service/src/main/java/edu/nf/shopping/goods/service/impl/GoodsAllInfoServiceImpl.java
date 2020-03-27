package edu.nf.shopping.goods.service.impl;

import edu.nf.shopping.goods.entity.GoodsAllInfo;
import edu.nf.shopping.goods.service.GoodsAllInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Achine
 * @date 2020/3/27
 */
@Service("goodsAllInfoService")
public class GoodsAllInfoServiceImpl implements GoodsAllInfoService {
    @Override
    public List<GoodsAllInfo> getGoodsInfoById(String goodId) {
        return null;
    }
}
