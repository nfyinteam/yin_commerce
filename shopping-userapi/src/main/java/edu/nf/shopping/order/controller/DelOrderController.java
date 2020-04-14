package edu.nf.shopping.order.controller;

import edu.nf.shopping.order.entity.OrderInfo;
import edu.nf.shopping.order.service.DelOrderInfoService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author Achine
 * @date 2020/4/9
 */
@RestController
public class DelOrderController extends BaseController {

    @Autowired
    private DelOrderInfoService delOrderInfoService;

    @PostMapping("/del/order")
    @ApiOperation(value = "删除订单", notes = "根据订单编号删除订单信息，没有返回值",
            httpMethod = "post")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单编号", required = true)
    })
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    public ResponseVO delOrderInfo(@RequestParam("orderId") String orderId){
        delOrderInfoService.delOrderInfo(orderId);
        return success(200, "删除成功");
    }
}
