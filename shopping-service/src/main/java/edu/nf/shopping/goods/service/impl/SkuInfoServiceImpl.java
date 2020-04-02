package edu.nf.shopping.goods.service.impl;

import edu.nf.shopping.goods.dao.SkuInfoDao;
import edu.nf.shopping.goods.dao.SkuRelationDao;
import edu.nf.shopping.goods.entity.SkuAllInfo;
import edu.nf.shopping.goods.entity.SkuInfo;
import edu.nf.shopping.goods.exception.GoodsException;
import edu.nf.shopping.goods.exception.SkuInfoException;
import edu.nf.shopping.goods.service.SkuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Achine
 * @date 2020/4/2
 */
@Service("skuInfoService")
@Transactional(rollbackFor = SkuInfoException.class)
public class SkuInfoServiceImpl implements SkuInfoService {

    @Autowired
    private SkuInfoDao skuInfoDao;

    @Autowired
    private SkuRelationDao skuRelationDao;

    @Override
    @Cacheable(value = "goodsCache", key = "#skuId", condition = "#skuId != null or #skuId != ''")
    public SkuAllInfo getSkuAllInfoBySkuId(String skuId) {
        SkuAllInfo skuAllInfo = new SkuAllInfo();
        try {
            skuAllInfo.setSkuInfo(skuInfoDao.getSkuInfoBySkuId(skuId));
            if(skuAllInfo.getSkuInfo() == null){
                throw new SkuInfoException("该SKU不存在");
            }
            skuAllInfo.setSkuRelations(skuRelationDao.listSkuRelationBySkuId(skuId));
        }catch (Exception e){
            throw new SkuInfoException(e);
        }
        return skuAllInfo;
    }

    @Override
    @Cacheable(value = "goodsCache", key = "#skuId", condition = "#skuId != null")
    public List<SkuAllInfo> getSkuAllInfoBySkuId(String... skuId) {
        List<SkuAllInfo> list = new ArrayList<>();
        try {
            for (String id : skuId){
                SkuAllInfo skuAllInfo = new SkuAllInfo();
                skuAllInfo.setSkuInfo(skuInfoDao.getSkuInfoBySkuId(id));
                if(skuAllInfo.getSkuInfo() == null){
                    throw new SkuInfoException("该SKU不存在");
                }
                skuAllInfo.setSkuRelations(skuRelationDao.listSkuRelationBySkuId(id));
                list.add(skuAllInfo);
            }
        }catch (Exception e){
            throw new SkuInfoException(e);
        }
        return list;
    }

    @Override
    @CacheEvict(value = "goodsCache", key = "#skuInfo.skuId",beforeInvocation=true)
    public void addSkuInfo(SkuInfo skuInfo) {
        try {
            skuInfoDao.addSkuInfo(skuInfo);
        }catch (Exception e){
            throw new SkuInfoException(e);
        }
    }

    @Override
    @CacheEvict(value = "goodsCache", key = "#skuInfo.skuId",beforeInvocation=true)
    public void updateSkuInfo(SkuInfo skuInfo) {
        try {
            SkuInfo sku = skuInfoDao.getSkuInfoBySkuId(skuInfo.getSkuId());
            if(sku == null){
                throw new SkuInfoException("该sku不存在");
            }
            skuInfoDao.updateSkuInfo(skuInfo);
        }catch (Exception e){
            throw new SkuInfoException(e);
        }
    }

    @Override
    @CacheEvict(value = "goodsCache", key = "#skuId",beforeInvocation=true)
    public void deleteSkuInfo(String skuId) {
        try {
            skuInfoDao.deleteSkuInfo(skuId);
        }catch (Exception e){
            throw new SkuInfoException(e);
        }
    }
}
