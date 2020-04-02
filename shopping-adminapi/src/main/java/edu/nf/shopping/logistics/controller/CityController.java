package edu.nf.shopping.logistics.controller;

import edu.nf.shopping.logistics.entity.ReturnCityMap;
import edu.nf.shopping.logistics.exception.LogisticsException;
import edu.nf.shopping.logistics.service.CityService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lishun
 * @date 2020/4/3
 */
@RestController
public class CityController extends BaseController {
    @Autowired
    private CityService service;
    @GetMapping("/getCityMap")
    @ApiOperation(value = "获取城市下拉框",notes = "获取城市下拉框,返回ReturnCityMap",httpMethod = "get")

    public ResponseVO getCityMap(){
        try {

           return success( service.getCityMap());
        } catch (Exception e) {
            e.printStackTrace();
            throw new LogisticsException("服务器错误");
        }
    }
}
