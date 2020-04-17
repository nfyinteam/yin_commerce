package edu.nf.shopping.order.controller;

import edu.nf.shopping.order.entity.OrderDetails;
import edu.nf.shopping.order.entity.OrderInfo;
import edu.nf.shopping.order.service.CommitOrderInfoService;
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
public class CommitOrderController extends BaseController {

    @Autowired
    private CommitOrderInfoService orderInfoService;

    @PostMapping("/commit/order")
    @ApiOperation(value = "提交订单", notes = "传入订单信息，包括参数（订单编号，用户地址编号）提交订单，返回的是OrderInfo对象",
            httpMethod = "post")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单编号", required = true),
            @ApiImplicitParam(name = "addressId", value = "用户地址编号", required = true),
            @ApiImplicitParam(name = "buyRemark", value = "买家备注", required = true)
    })
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    public ResponseVO<OrderInfo> commitOrder(@RequestParam("orderId") String orderId, @RequestParam("addressId") String addressId,
                                             @RequestParam("buyRemark") String buyRemark){

        OrderInfo order = orderInfoService.commitOrderInfo(orderId, buyRemark, addressId);
        return success(order);
    }
}
