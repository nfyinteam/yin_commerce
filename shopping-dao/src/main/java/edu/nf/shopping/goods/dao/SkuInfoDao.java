package edu.nf.shopping.goods.dao;

import edu.nf.shopping.goods.entity.SkuInfo;

/**
 * @author Achine
 * @date 2020/4/2
 */
public interface SkuInfoDao {
    /**
     * 根据sku编号获取SkuInfo
     * @param skuId sku编号
     * @return
     */
    SkuInfo getSkuInfoBySkuId(String skuId);

    /**
     * 添加SkuInfo
     * @param skuInfo
     */
    void addSkuInfo(SkuInfo skuInfo);

    /**
     * 修改SkuInfo
     * @param skuInfo
     */
    void updateSkuInfo(SkuInfo skuInfo);

    /**
     * 删除SkuInfo
     * @param skuId
     */
    void deleteSkuInfo(String skuId);
}