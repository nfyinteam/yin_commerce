package edu.nf.shopping.goods.service.impl;

import edu.nf.shopping.goods.dao.GoodsImgsDao;
import edu.nf.shopping.goods.entity.GoodsImgs;
import edu.nf.shopping.goods.entity.ImgsInfo;
import edu.nf.shopping.goods.exception.GoodsImgException;
import edu.nf.shopping.goods.exception.ImgsInfoException;
import edu.nf.shopping.goods.service.ImgsInfoService;
import edu.nf.shopping.goods.service.InsertGoodImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Achine
 * @date 2020/4/2
 */
@Service("insertGoodImgService")
@Transactional(rollbackFor = GoodsImgException.class)
public class InsertGoodImgServiceImpl implements InsertGoodImgService {

    @Autowired
    private GoodsImgsDao dao;

    @Autowired
    private ImgsInfoService imgsInfoService;

    @Override
    @CachePut(value = "goodsCache", key = "imgsInfo-2")
    public GoodsImgs addGoodImg(GoodsImgs goodsImgs, MultipartFile file) {
        try {
            ImgsInfo imgsInfo = imgsInfoService.addImgsInfo(file, 1);
            if(goodsImgs.getGood().getGoodsId() == null && goodsImgs.getGood().getGoodsId() == ""){
                throw new GoodsImgException("商品图片不能为空");
            }
            goodsImgs.setImg(imgsInfo);
            goodsImgs.setImgIndex(0);
            dao.addGoodsImgs(goodsImgs);
            return goodsImgs;
        }catch (Exception e){
            throw new GoodsImgException(e);
        }
    }
}
