package edu.nf.shopping.goods.service;

import edu.nf.shopping.goods.entity.SkuAllInfo;
import edu.nf.shopping.goods.entity.SkuInfo;

/**
 * @author Achine
 * @date 2020/4/2
 */
public interface SkuInfoService {

    SkuAllInfo getSkuAllInfoBySkuId(String skuId);

    void addSkuInfo(SkuInfo skuInfo);

    void updateSkuInfo(SkuInfo skuInfo);

    void deleteSkuInfo(String skuId);
}