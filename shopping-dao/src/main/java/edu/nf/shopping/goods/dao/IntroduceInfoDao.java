package edu.nf.shopping.goods.dao;

import edu.nf.shopping.goods.entity.IntroduceInfo;

import java.util.List;

/**
 * @author Achine
 * @date 2020/3/18
 */
public interface IntroduceInfoDao {

    /**
     * 根据商品编号，查询商品介绍
     * @param goodsId
     * @return
     */
    List<IntroduceInfo> listIntroduceInfoByGoodsId(String goodsId);

    /**
     * 根据介绍编号查询介绍信息
     * @param introduceId 介绍编号
     * @return
     */
    IntroduceInfo getIntroduceInfoByIntroduceId(Integer introduceId);

    /**
     * 添加介绍信息
     * @param introduceInfo 介绍信息
     */
    void addIntroduceInfo(IntroduceInfo introduceInfo);

    /**
     * 修改介绍信息
     * @param introduceInfo 介绍信息
     */
    void updateIntroduceInfo(IntroduceInfo introduceInfo);

    /**
     * 删除介绍信息
     * @param introduceId 介绍编号
     */
    void deleteIntroduceInfo(Integer introduceId);
}
