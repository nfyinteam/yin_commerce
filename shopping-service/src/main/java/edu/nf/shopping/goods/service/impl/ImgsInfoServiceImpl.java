package edu.nf.shopping.goods.service.impl;

import edu.nf.shopping.goods.dao.ImgsInfoDao;
import edu.nf.shopping.goods.entity.ImgsInfo;
import edu.nf.shopping.goods.entity.ImgsType;
import edu.nf.shopping.goods.exception.ImgsInfoException;
import edu.nf.shopping.goods.service.ImgsInfoService;
import edu.nf.shopping.util.FileNameUtils;
import edu.nf.shopping.util.UploadAddressUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Achine
 * @date 2020/4/2
 */
@Service("imgsInfoService")
@Transactional(rollbackFor = ImgsInfoException.class)
public class ImgsInfoServiceImpl implements ImgsInfoService {

    @Autowired
    private ImgsInfoDao dao;

    /**
     * 查询所有图片
     * @return
     */
    @Override
    @Cacheable(value = "goodsCache", key = "imgsInfo-1", condition = "#skuId != null")
    public List<ImgsInfo> listImgsInfo() {
        try {
            return dao.listImgsInfo();
        }catch (Exception e){
            throw new ImgsInfoException(e);
        }
    }

    /**
     * 根据图片编号查询图片
     * @return
     */
    @Override
    @Cacheable(value = "goodsCache", key = "#imgId", condition = "#skuId != null")
    public ImgsInfo getImgsInfoByImgId(String imgId) {
        try {
            return dao.getImgsInfoByImgId(imgId);
        }catch (Exception e){
            throw new ImgsInfoException(e);
        }
    }

    /**
     * 添加图片
     * @param file
     */
    @Override
    @CacheEvict(value = "goodsCache", key = "imgsInfo-2",beforeInvocation=true)
    public ImgsInfo addImgsInfo(MultipartFile file, Integer imgType) {
        try {
            String fileName = file.getOriginalFilename().split(".")[file.getOriginalFilename().split(".").length];
            String newName = FileNameUtils.newFileName(fileName);
            FileNameUtils.upload(UploadAddressUtils.GOODS_IMAGES,file.getInputStream(),newName);
            ImgsInfo imgsInfo = new ImgsInfo();
            imgsInfo.setImgId(newName.split(".")[0]);
            imgsInfo.setImgName(newName);
            imgsInfo.setImgFile(newName);
            ImgsType imgsType = new ImgsType();
            imgsType.setItId(imgType);
            imgsInfo.setImgType(imgsType);
            dao.addImgsInfo(imgsInfo);
            return imgsInfo;
        }catch (Exception e){
            throw new ImgsInfoException(e);
        }
    }

    /**
     * 修改图片
     * @param imgsInfo
     */
    @Override
    @CacheEvict(value = "goodsCache", key = "imgsInfo-2",beforeInvocation=true)
    public void updateImgsInfo(ImgsInfo imgsInfo) {
        try {
            ImgsInfo img = dao.getImgsInfoByImgId(imgsInfo.getImgId());
            if(img == null){
                throw new ImgsInfoException("该图片信息是空的");
            }
            dao.updateImgsInfo(imgsInfo);
        }catch (Exception e){
            throw new ImgsInfoException(e);
        }
    }

    /**
     * 删除图片
     * @param imgId
     */
    @Override
    @CacheEvict(value = "goodsCache", key = "imgsInfo-2",beforeInvocation=true)
    public void deleteImgsInfo(String imgId) {
        try {
            dao.deleteImgsInfo(imgId);
        }catch (Exception e){
            throw new ImgsInfoException(e);
        }
    }
}
