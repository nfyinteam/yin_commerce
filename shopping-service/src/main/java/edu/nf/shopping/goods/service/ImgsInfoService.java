package edu.nf.shopping.goods.service;

import edu.nf.shopping.goods.entity.ImgsInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Achine
 * @date 2020/4/2
 */
public interface ImgsInfoService {
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
     * @param file
     */
    ImgsInfo addImgsInfo(MultipartFile file, Integer imgType);

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