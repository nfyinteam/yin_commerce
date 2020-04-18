package edu.nf.shopping.order.controller;

import edu.nf.shopping.order.entity.OrderInfo;
import edu.nf.shopping.order.service.CancelOrderInfoService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Achine
 * @date 2020/4/9
 */
@RestController
public class CancelOrderController extends BaseController {

    @Autowired
    private CancelOrderInfoService cancelOrderInfoService;

    @PostMapping("/cancel/order")
    @ApiOperation(value = "取消订单", notes = "根据订单编号取消订单信息，返回OrderInfo对象",
            httpMethod = "post")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单编号", required = true)
    })
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    public ResponseVO<OrderInfo> delOrderInfo(@RequestParam("orderId") String orderId){
        OrderInfo orderInfo = cancelOrderInfoService.cancelOrderInfoService(orderId);
        return success(orderInfo);
    }
}
