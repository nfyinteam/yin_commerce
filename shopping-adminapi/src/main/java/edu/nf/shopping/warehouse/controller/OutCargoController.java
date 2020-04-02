package edu.nf.shopping.warehouse.controller;

import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import edu.nf.shopping.warehouse.entity.OutCargo;
import edu.nf.shopping.warehouse.exception.WarehouseException;
import edu.nf.shopping.warehouse.service.OutCargoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lishun
 * @date 2020/4/1
 */
@RestController
public class OutCargoController  extends BaseController {
    @Autowired
    private OutCargoService service;
    @PostMapping("/insertOutCargo/{outCargo}")
    @ApiOperation(value = "插入货物出货信息",notes = "插入货物出货信息,返回200或500",httpMethod = "post")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "outCargo",value = "OutCargo对象",required = true)
    })
    public ResponseVO insertOutCargo(OutCargo outCargo){
        try {
            service.insertOutCargo(outCargo);
            return success(200);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WarehouseException("服务器错误");
        }
    }
}
