package edu.nf.shopping.goods.service;

import edu.nf.shopping.goods.entity.GoodsImgs;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Achine
 * @date 2020/4/2
 */
public interface InsertGoodImgService {

    void addGoodImg(GoodsImgs goodsImgs, MultipartFile file);
}