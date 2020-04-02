package edu.nf.shopping.goods.controller;
import edu.nf.shopping.goods.entity.GoodsImgs;
import edu.nf.shopping.goods.service.InsertGoodImgService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Achine
 * @date 2020/3/13
 */
@RestController
public class ImgeUploadController extends BaseController {

    @Autowired
    private InsertGoodImgService service;

    @PutMapping(value="/upload/goodImg",headers = "content-type=multipart/*")
    @ApiOperation(value = "修改内容图片", notes = "修改区域的内容图片", httpMethod = "put")
    @ApiImplicitParams({
            @ApiImplicitParam( name = "goodsImgs",value = "商品图片信息",required = true),
            @ApiImplicitParam( name = "file",value = "图片文件",required = true),
    })
    @CrossOrigin(origins = "*", methods = {RequestMethod.PUT})
    private ResponseVO updateGoodsImage(GoodsImgs goodsImgs, @RequestParam("file") MultipartFile file) throws IOException {
        service.addGoodImg(goodsImgs, file);
        return success(200,"");
    }
}
