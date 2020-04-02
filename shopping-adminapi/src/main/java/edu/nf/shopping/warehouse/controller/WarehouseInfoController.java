package edu.nf.shopping.warehouse.controller;

import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import edu.nf.shopping.warehouse.entity.WarehouseInfo;
import edu.nf.shopping.warehouse.exception.WarehouseException;
import edu.nf.shopping.warehouse.service.WarehouseInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lishun
 * @date 2020/4/2
 */
@RestController
public class WarehouseInfoController extends BaseController {
    @Autowired
    private WarehouseInfoService service;
    @GetMapping("/listWarehouse")
    @ApiOperation(value = "获取仓库信息",notes = "获取仓库信息,返回listWarehouseInfo对象",httpMethod = "get")
    public ResponseVO listWarehouse(){
        try {
             return success(service.listWarehouse());
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }
    }
    @GetMapping("/getWarehouseByCitys/{cityName}")
    @ApiOperation(value = "根据城市查找仓库",notes = "根据城市查找仓库,返回listWarehouseInfo对象",httpMethod = "get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cityName",value = "城市名称",required = true)
    })
    public ResponseVO getWarehouseByCitys(String cityName){
        try {
           return success(service.getWarehouseByCitys(cityName));
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }
    }
    @PostMapping("/updateWarehouseById/{warehouseInfo}")
    @ApiOperation(value = "修改仓库信息",notes = "修改仓库信息,返回200",httpMethod = "post")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "warehouseInfo",value = "仓库信息",required = true)
    })
    public ResponseVO updateWarehouseById(WarehouseInfo warehouseInfo){
        try {
            service.updateWarehouseById(warehouseInfo);
            return success(200);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }
    }
    @GetMapping("/getWarehouseById/{warehouseId}")
    @ApiOperation(value = "获取仓库信息",notes = "获取仓库信息，返回仓库信息对象",httpMethod = "get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "warehouseId",value = "")
    })
    public ResponseVO getWarehouseById(String warehouseId){
        try {
            return success(service.getWarehouseById(warehouseId));
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }
    }
    @PostMapping ("/insertWarehouse/{warehouseInfo}")
    @ApiOperation(value = "获取仓库信息",notes = "获取仓库信息，返回仓库信息对象",httpMethod = "get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "warehouseId",value = "")
    })
    public ResponseVO insertWarehouse(WarehouseInfo warehouseInfo){
        try {
            service.insertWarehouse(warehouseInfo);
            return success(200);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }
    }
}
