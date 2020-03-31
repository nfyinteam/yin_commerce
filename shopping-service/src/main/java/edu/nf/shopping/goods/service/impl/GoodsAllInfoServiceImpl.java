package edu.nf.shopping.goods.service.impl;

import edu.nf.shopping.goods.dao.GoodsDao;
import edu.nf.shopping.goods.dao.GoodsImgsDao;
import edu.nf.shopping.goods.dao.IntroduceInfoDao;
import edu.nf.shopping.goods.dao.SkuRelationDao;
import edu.nf.shopping.goods.entity.GoodsAllInfo;
import edu.nf.shopping.goods.entity.SkuInfo;
import edu.nf.shopping.goods.entity.SkuRelation;
import edu.nf.shopping.goods.entity.ValueInfo;
import edu.nf.shopping.goods.exception.GoodsException;
import edu.nf.shopping.goods.service.GoodsAllInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            if(allInfo.getGoodsInfo() == null){
                throw new GoodsException("商品不存在");
            }
            allInfo.setGoodsImgs(goodsImgsDao.listGoodsImgsByGoodsId(goodId));
            allInfo.setIntroduceInfos(introduceInfoDao.listIntroduceInfoByGoodsId(goodId));
            List<SkuRelation> relations = skuRelationDao.listSkuRelationByGoodsId(goodId);
            allInfo.setSkuRelations(relations);
            //插入key与value
            Map<String, List<ValueInfo>> map = new HashMap<>();
            for (SkuRelation relation : relations){
                List<ValueInfo> list = map.get(relation.getKey().getKeyName());
                if(list == null){
                    list = new ArrayList<>();
                    map.put(relation.getKey().getKeyName(), list);
                }
                ValueInfo valueInfo = relation.getValue();
                SkuInfo skuInfo = relation.getSkuInfo();
                valueInfo.setSkuInfo(skuInfo);
                list.add(valueInfo);
                map.put(relation.getKey().getKeyName(), list);
            }
            allInfo.setSkuMap(map);
            return allInfo;
        }catch (Exception e){
            throw new GoodsException("服务器维护中。。");
        }
    }
}
