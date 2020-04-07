package edu.nf.shopping.goods.dao;

import edu.nf.shopping.goods.entity.ImgsInfo;

import java.util.List;

/**
 * @author Achine
 * @date 2020/4/2
 */
public interface ImgsInfoDao {
    /**
     * 查询所有图片
     * @return
     */
    List<ImgsInfo> listImgsInfo();

    /**
     * 根据图片编号查询图片信息
     * @param imgId 图片编号
     * @return
     */
    ImgsInfo getImgsInfoByImgId(String imgId);

    /**
     * 添加图片信息
     * @param imgsInfo
     */
    void addImgsInfo(ImgsInfo imgsInfo);

    /**
     * 修改图片信息
     * @param imgsInfo
     */
    void updateImgsInfo(ImgsInfo imgsInfo);

    /**
     * 删除图片信息
     * @param imgId
     */
    void deleteImgsInfo(String imgId);
}