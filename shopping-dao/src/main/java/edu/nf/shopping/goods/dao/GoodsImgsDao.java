package edu.nf.shopping.goods.dao;

import edu.nf.shopping.goods.entity.GoodsImgs;
import edu.nf.shopping.goods.entity.ImgsInfo;

import java.util.List;

/**
 * @author Achine
 * @date 2020/3/17
 */
public interface GoodsImgsDao {

    /**
     * 查询所有商品的图片
     * @return
     */
    List<ImgsInfo> listGoodsImgs();

    /**
     * 根据商品ID查询商品图片
     * @param goodsId 商品编号
     * @return
     */
    List<ImgsInfo> listGoodsImgsByGoodsId(String goodsId);

    /**
     * 根据商品编号查询下标为1的商品图片
     * @param goodsId 商品编号
     * @return
     */
    List<ImgsInfo> listFirstGoodsImgsByGoodsId(String ... goodsId);

    /**
     * 根据图片编号imgId查询该图片相关的信息
     * @param imgId 图片编号
     * @return
     */
    List<GoodsImgs> listGoodsImgsByImgId(String imgId);

    /**
     * 添加商品图片
     * @param goodsImg 商品图片
     */
    void addGoodsImgs(GoodsImgs goodsImg);

    /**
     * 修改商品图片
     * @param goodsImg 商品图片
     */
    void updateGoodsImgs(GoodsImgs goodsImg);

    /**
     * 删除商品图片根据商品编号和图片编号
     * @param goodsImg 商品图片
     */
    void deleteGoodsImgs(GoodsImgs goodsImg);
}