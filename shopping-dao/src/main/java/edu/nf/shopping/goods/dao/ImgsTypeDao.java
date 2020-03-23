package edu.nf.shopping.goods.dao;

import java.util.List;

/**
 * @author Achine
 * @date 2020/3/17
 */
public interface ImgsTypeDao {

    /**
     * 查询所有图片类型
     * @return
     */
    List<ImgsTypeDao> listImgsType();

    /**
     * 根据图片类型编号查询图片类型信息
     * @param itId 图片类型编号
     * @return
     */
    ImgsTypeDao getImgsTypeById(Integer itId);

    /**
     * 添加图片类型
     * @param imgsType 图片类型
     */
    void addImgsType(ImgsTypeDao imgsType);

    /**
     * 修改图片类型
     * @param imgsType 图片类型
     */
    void updateImgsType(ImgsTypeDao imgsType);

    /**
     * 删除图片类型
     * @param itId 图片类型编号
     */
    void deleteImgsType(Integer itId);
}
