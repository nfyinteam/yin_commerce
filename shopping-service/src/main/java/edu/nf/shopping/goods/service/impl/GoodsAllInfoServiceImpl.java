package edu.nf.shopping.goods.service.impl;

import edu.nf.shopping.goods.dao.GoodsDao;
import edu.nf.shopping.goods.dao.GoodsImgsDao;
import edu.nf.shopping.goods.dao.IntroduceInfoDao;
import edu.nf.shopping.goods.dao.SkuRelationDao;
import edu.nf.shopping.goods.entity.GoodsAllInfo;
import edu.nf.shopping.goods.entity.GoodsImgs;
import edu.nf.shopping.goods.entity.GoodsInfo;
import edu.nf.shopping.goods.exception.GoodsException;
import edu.nf.shopping.goods.service.GoodsAllInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Achine
 * @date 2020/3/27
 */
@Service("goodsAllInfoService")
public class GoodsAllInfoServiceImpl implements GoodsAllInfoService {
    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private GoodsImgsDao goodsImgsDao;

    @Autowired
    private IntroduceInfoDao introduceInfoDao;

    @Autowired
    private SkuRelationDao skuRelationDao;


    @Override
    @Cacheable(value = "cache1", key = "#goodId", condition = "#goodId != null or #goodId != ''"  )
    public GoodsAllInfo getGoodsInfoById(String goodId) {
        try {
            GoodsAllInfo allInfo = new GoodsAllInfo();
            allInfo.setGoodsInfo(goodsDao.getGoodsById(goodId));
            allInfo.setGoodsImgs(goodsImgsDao.listGoodsImgsByGoodsId(goodId));
            allInfo.setIntroduceInfos(introduceInfoDao.listIntroduceInfoByGoodsId(goodId));
            allInfo.setSkuRelations(skuRelationDao.listSkuRelationByGoodsId(goodId));
            return allInfo;
        }catch (Exception e){
            throw new GoodsException("服务器维护中。。");
        }
    }
}
