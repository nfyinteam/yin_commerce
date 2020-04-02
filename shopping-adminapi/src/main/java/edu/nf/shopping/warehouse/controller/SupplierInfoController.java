package edu.nf.shopping.warehouse.controller;

import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import edu.nf.shopping.warehouse.entity.SupplierInfo;
import edu.nf.shopping.warehouse.exception.WarehouseException;
import edu.nf.shopping.warehouse.service.SupplierInfoService;
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
public class SupplierInfoController extends BaseController {
    @Autowired
    private SupplierInfoService service;
    @GetMapping("/listSupplierInfo")
    @ApiOperation(value = "获取所有供应商",notes = "获取所有供应商，返回supplierInfoList对象",httpMethod = "get")
    public ResponseVO listSupplierInfo(){
        try {
            return  success(service.listSupplierInfo());
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }

    }
    @PostMapping("/insertSupplierInfo/{supplierInfo}")
    @ApiOperation(value = "获取所有供应商",notes = "添加供应商信息，返回200",httpMethod = "post")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "supplierInfo",value = "供应商信息",required = true)
    })
    public ResponseVO insertSupplierInfo(SupplierInfo supplierInfo){
        try {
            service.insertSupplierInfo(supplierInfo);
            return success(200);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }
    }
    @PostMapping("/updateSupplierInfoByid/{supplierInfo}")
    @ApiOperation(value = "修改所有供应商",notes = "修改供应商信息，返回200",httpMethod = "post")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "supplierInfo",value = "供应商信息",required = true)
    })
    public ResponseVO updateSupplierInfoByid(SupplierInfo supplierInfo){
        try {
            service.updateSupplierInfoByid(supplierInfo);
           return success(200);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }
    }
    @PostMapping("/deleteSupplierInfo/{id}")
    @ApiOperation(value = "删除供应商",notes = "删除供应商信息，返回200and500",httpMethod = "post")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "supplierInfo",value = "供应商信息",required = true)
    })
    public ResponseVO deleteSupplierInfo(Integer id){
        try {
            service.deleteSupplierInfo(id);
            return success(200);
        } catch (Exception e) {
            e.printStackTrace();

            throw new WarehouseException("服务器错误");
        }
    }
    @GetMapping("/listSupplierGoodsById/{id}")
    @ApiOperation(value = "获取供应商信息",notes = "，返回SupplierInfo",httpMethod = "get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "supplierInfo",value = "供应商id",required = true)
    })
    public ResponseVO  listSupplierGoodsById(Integer id){
        try {

            return success(service.listSupplierGoodsById(id));
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }
    }
}
