package edu.nf.shopping.goods.service.impl;

import edu.nf.shopping.goods.dao.SkuInfoDao;
import edu.nf.shopping.goods.dao.SkuRelationDao;
import edu.nf.shopping.goods.entity.SkuAllInfo;
import edu.nf.shopping.goods.entity.SkuInfo;
import edu.nf.shopping.goods.exception.SkuInfoException;
import edu.nf.shopping.goods.service.SkuInfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Achine
 * @date 2020/4/2
 */
public class SkuInfoServiceImpl implements SkuInfoService {

    @Autowired
    private SkuInfoDao skuInfoDao;

    @Autowired
    private SkuRelationDao skuRelationDao;

    @Override
    public SkuAllInfo getSkuAllInfoBySkuId(String skuId) {
        SkuAllInfo skuAllInfo = new SkuAllInfo();
        try {
            skuAllInfo.setSkuInfo(skuInfoDao.getSkuInfoBySkuId(skuId));
            skuAllInfo.setSkuRelations(skuRelationDao.listSkuRelationBySkuId(skuId));
        }catch (Exception e){
            throw new SkuInfoException(e);
        }
        return skuAllInfo;
    }

    @Override
    public void addSkuInfo(SkuInfo skuInfo) {
        try {
            skuInfoDao.addSkuInfo(skuInfo);
        }catch (Exception e){
            throw new SkuInfoException(e);
        }
    }

    @Override
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
    public void deleteSkuInfo(String skuId) {
        try {
            skuInfoDao.deleteSkuInfo(skuId);
        }catch (Exception e){
            throw new SkuInfoException(e);
        }
    }
}
