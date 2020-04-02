package edu.nf.shopping.goods.controller;

import edu.nf.shopping.goods.entity.GoodsAllInfo;
import edu.nf.shopping.goods.service.GoodsAllInfoService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Achine
 * @date 2020/3/30
 */
@RestController
public class GoodsAllInfoController extends BaseController {
    @Autowired
    private GoodsAllInfoService service;

    @GetMapping("/goodsAllInfo/{goodId}")
    @ApiOperation(value = "根据商品ID查询商品相关信息", notes = "根据商品ID查询商品相关信息，返回的是GoodsAllInfo对象",
            httpMethod = "get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodId", value = "商品编号", required = true)
    })
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVO<GoodsAllInfo> getGoodsAllInfoByGoodsId(@PathVariable("goodId") String goodId){
        return success(service.getGoodsInfoById(goodId));
    }
}
