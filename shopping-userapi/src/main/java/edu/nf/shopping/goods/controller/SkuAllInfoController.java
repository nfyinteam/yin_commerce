package edu.nf.shopping.goods.controller;

import edu.nf.shopping.goods.entity.SkuAllInfo;
import edu.nf.shopping.goods.service.SkuInfoService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Achine
 * @date 2020/4/2
 */
@RestController
public class SkuAllInfoController extends BaseController {
    @Autowired
    private SkuInfoService skuInfoService;

    @GetMapping("/skuAllInfos")
    @ApiOperation(value = "SkuId", notes = "根据skuId查询商品Sku消息，返回的是SkuAllInfo对象",
            httpMethod = "get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "SkuId", value = "sku编号", required = true)
    })
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVO<List<SkuAllInfo>> getSkuAllInfo(String ... skuId){
        return success(skuInfoService.getSkuAllInfoBySkuId(skuId));
    }
}
