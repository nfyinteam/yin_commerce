package edu.nf.shopping.order.controller;

import edu.nf.shopping.order.entity.OrderDetails;
import edu.nf.shopping.order.entity.OrderInfo;
import edu.nf.shopping.order.service.InitOrderInfoService;
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
public class InitOrderController extends BaseController {

    @Autowired
    private InitOrderInfoService initOrderInfoService;

    @PostMapping("/init/order")
    @ApiOperation(value = "初始化订单", notes = "传入订单明细信息，包括参数（skuId, skuNum）初始化订单，返回的是OrderInfo对象",
            httpMethod = "post")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderDetails", value = "订单明细", required = true)
    })
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    public ResponseVO<OrderInfo> initOrder(@RequestParam("orderDetails") List<OrderDetails> orderDetails, HttpSession session){
        String userId = (String) session.getAttribute("userId");
        OrderInfo order = initOrderInfoService.initOrderInfo(userId, orderDetails);
        return success(order);
    }
}
