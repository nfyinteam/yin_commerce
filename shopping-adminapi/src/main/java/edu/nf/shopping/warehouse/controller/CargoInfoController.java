package edu.nf.shopping.warehouse.controller;

import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import edu.nf.shopping.warehouse.entity.CargoInfo;
import edu.nf.shopping.warehouse.exception.WarehouseException;
import edu.nf.shopping.warehouse.service.CargoInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.CssLinkResourceTransformer;
import springfox.documentation.annotations.Cacheable;

import java.util.List;

/**
 * @author lishun
 * @date 2020/3/31
 */
@RestController
public class CargoInfoController extends BaseController {
    @Autowired
    private CargoInfoService service;
    @GetMapping("/getListCargoInfo")
    @ApiOperation(value = "查询所有货物",notes = "无条件查询所有货物，返回CargoInfo集合",httpMethod = "get")
    public ResponseVO listCargoInfo(){

        try {
            List<CargoInfo> cargoInfos = service.listCargoInfo();
            return  success(cargoInfos);

        } catch (Exception e) {
            e.printStackTrace();
            throw  new WarehouseException("服务器错误");
        }

    }
    @PostMapping("/insertCargoInfo/{cargoInfo}")
    @ApiOperation(value = "添加货物",notes = "添加货物，返回200或者500",httpMethod = "post")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cargoInfo",value = "CargoInfo对象",required = true)
    })
    public ResponseVO insertCargoInfo(CargoInfo cargoInfo){
        try {
            service.insertCargoInfo(cargoInfo);
            return success(200);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new WarehouseException("服务器错误");
        }
    }
    @DeleteMapping("/deleteCargoInfo/{cargoId}")
    @ApiOperation(value = "删除货物",notes = "删除货物，返回200或者500",httpMethod = "delete")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cargoId" ,value = "货物id",required = true)
    })
    public ResponseVO deleteCargoInfo(String cargoId){
        try {
            service.deleteCargoInfo(cargoId);
            return success(200);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new WarehouseException("服务器错误");
        }
    }
    @GetMapping("/getCargoInfoById/{cargoId}")
    @ApiOperation(value = "获取单个货物",notes = "获取单个货物，返回CargoInfo对象",httpMethod = "get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cargoId" ,value = "货物id",required = true)
    })
    public ResponseVO getCargoInfoById(String cargoId){
        try {
            return  success(service.getCargoInfoById(cargoId));

        } catch (Exception e) {

            e.printStackTrace();
            throw  new WarehouseException("服务器错误");
        }
    }
    @PostMapping("/updateCargoWarehousing/{cargoId}")
    @ApiOperation(value = "货物入库",notes = "货物入库,返回CargoInfo对象",httpMethod = "post")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "cargoId",value = "货物id",required = true)
    })
    public ResponseVO updateCargoWarehousing(String cargoId){
        try {
            service.updateCargoWarehousing(cargoId);
             return success(200);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }
    }
    @PostMapping("/updateCargoALibrary/{cargoId}")
    @ApiOperation(value = "货物出库",notes = "货物出库,返回CargoInfo对象",httpMethod = "post")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cargoId",value = "货物id",required = true)
    })
    public ResponseVO updateCargoALibrary(String cargoId){
        try {
            service.updateCargoALibrary(cargoId);
            return success(200);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }
    }
    @GetMapping("getCargoIdBySkuId")
    @ApiOperation(value = "返回指定商品库存货物id",notes = "返回指定商品库存货物id,返回货物ID",httpMethod = "get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "skuId",value = "skuid",required = true)
    })
    public ResponseVO getCargoIdBySkuId(String skuId){
        try {
            return success(service.getCargoIdBySkuId(skuId));
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }
    }
}
