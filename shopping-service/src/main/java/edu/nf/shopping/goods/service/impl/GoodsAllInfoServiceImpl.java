package edu.nf.shopping.goods.service.impl;

import edu.nf.shopping.goods.dao.*;
import edu.nf.shopping.goods.entity.*;
import edu.nf.shopping.goods.exception.GoodsException;
import edu.nf.shopping.goods.exception.ImgsInfoException;
import edu.nf.shopping.goods.service.GoodsAllInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Achine
 * @date 2020/3/27
 */
@Service("goodsAllInfoService")
@Transactional(rollbackFor = GoodsException.class)
public class GoodsAllInfoServiceImpl implements GoodsAllInfoService {
    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private GoodsImgsDao goodsImgsDao;

    @Autowired
    private IntroduceInfoDao introduceInfoDao;

    @Autowired
    private SkuRelationDao skuRelationDao;

    @Autowired
    private IntroduceTypeDao introduceTypeDao;

    @Autowired
    private KeyRelationDao keyRelationDao;


    @Override
    @Cacheable(value = "goodsCache", key = "#goodId", condition = "#goodId != null or #goodId != ''")
    public GoodsAllInfo getGoodsInfoById(String goodId) {
        try {
            GoodsAllInfo allInfo = new GoodsAllInfo();
            GoodsInfo goodsInfo = goodsDao.getGoodsById(goodId);
            if(goodsInfo == null){
                throw new GoodsException("商品不存在");
            }
            allInfo.setGoodsInfo(goodsInfo);
            allInfo.setGoodsImgs(goodsImgsDao.listGoodsImgsByGoodsId(goodId));
            List<SkuRelation> relations = skuRelationDao.listSkuRelationByGoodsId(goodId);
            if(relations != null){
                allInfo.setSkuRelations(relations);
                //插入key与value
                Map<String, List<ValueInfo>> map = new HashMap<>();
                for (SkuRelation relation : relations){
                    if(relation.getKey().getKeyName() != null){
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
                }
                allInfo.setSkuMap(map);
            }
            allInfo.setIntroduceTypes(introduceTypeDao.listIntroduceTypeByGoodId(goodId));
            //插入介绍类型和介绍内容
            List<IntroduceInfo> introduceInfos = introduceInfoDao.listIntroduceInfoByGoodsId(goodId);
            if(introduceInfos != null){
                Map<String, List<IntroduceInfo>> introduceMap = new HashMap<>();
                for (IntroduceInfo introduceInfo : introduceInfos){
                    if(introduceInfo.getIntroduceType().getItName() != null){
                        List<IntroduceInfo> list = introduceMap.get(introduceInfo.getIntroduceType().getItName());
                        if(list == null){
                            list = new ArrayList<>();
                            introduceMap.put(introduceInfo.getIntroduceType().getItName(), list);
                        }
                        list.add(introduceInfo);
                        introduceMap.put(introduceInfo.getIntroduceType().getItName(), list);
                    }
                }
                allInfo.setIntroduceMap(introduceMap);
                allInfo.setIntroduceInfos(introduceInfos);
            }
            //插入关键值类型和关键属性内容
            List<KeyRelation> keyRelations = keyRelationDao.listKeyRelationByGoodsId(goodId);
            if(keyRelations != null){
                Map<String, List<KeyRelation>> keyRelationMap = new HashMap<>();
                for (KeyRelation keyRelation : keyRelations){
                    if(keyRelation.getKey().getKeyType().getKtName() != null){
                        List<KeyRelation> list = keyRelationMap.get(keyRelation.getKey().getKeyType().getKtName());
                        if(list == null){
                            list = new ArrayList<>();
                            keyRelationMap.put(keyRelation.getKey().getKeyType().getKtName(), list);
                        }
                        list.add(keyRelation);
                        keyRelationMap.put(keyRelation.getKey().getKeyType().getKtName(), list);
                    }
                }
                allInfo.setKeyRelationMap(keyRelationMap);
            }
            return allInfo;
        }catch (Exception e){
            e.printStackTrace();
            throw new GoodsException("服务器维护中。。");
        }
    }
}
