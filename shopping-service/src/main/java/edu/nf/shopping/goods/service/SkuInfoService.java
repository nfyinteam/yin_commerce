package edu.nf.shopping.goods.service;

import edu.nf.shopping.goods.entity.SkuAllInfo;
import edu.nf.shopping.goods.entity.SkuInfo;

import java.util.List;

/**
 * @author Achine
 * @date 2020/4/2
 */
public interface SkuInfoService {

    SkuAllInfo getSkuAllInfoBySkuId(String skuId);

    List<SkuAllInfo> getSkuAllInfoBySkuId(String userId, String... skuId);

    void addSkuInfo(SkuInfo skuInfo);

    void updateSkuInfo(SkuInfo skuInfo);

    void deleteSkuInfo(String skuId);
}