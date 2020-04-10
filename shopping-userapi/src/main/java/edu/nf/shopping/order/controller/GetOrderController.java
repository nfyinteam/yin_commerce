package edu.nf.shopping.order.controller;

import edu.nf.shopping.order.entity.OrderInfo;
import edu.nf.shopping.order.service.OrderInfoService;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Achine
 * @date 2020/4/9
 */
@RestController
public class GetOrderController extends BaseController {

    @Autowired
    private OrderInfoService orderInfoService;

    @GetMapping("/get/order")
    @ApiOperation(value = "获取订单", notes = "根据订单编号获取订单信息，返回的是OrderInfo对象",
            httpMethod = "get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单编号", required = true)
    })
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVO<OrderInfo> initOrder(@PathVariable("orderId") String orderId, HttpSession session){
        OrderInfo order = orderInfoService.getOrderInfoByOrderId(orderId);
        return success(order);
    }
}
