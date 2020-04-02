package edu.nf.shopping.goods.dao;

import edu.nf.shopping.goods.entity.IntroduceType;

import java.util.List;

/**
 * @author Achine
 * @date 2020/3/31
 */
public interface IntroduceTypeDao {
    /**
     * 查询所有介绍类型
     * @return
     */
    List<IntroduceType> listIntroduceType();

    /**
     * 根据商品编号查询所有介绍类型，并排序
     * @param goodId 商品编号
     * @return
     */
    List<IntroduceType> listIntroduceTypeByGoodId(String goodId);
}