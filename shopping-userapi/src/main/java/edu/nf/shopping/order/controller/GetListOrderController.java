package edu.nf.shopping.order.controller;

import edu.nf.shopping.order.entity.OrderDetails;
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
public class GetListOrderController extends BaseController {

    @Autowired
    private OrderInfoService orderInfoService;

    @GetMapping("/get/orders")
    @ApiOperation(value = "获取所有订单", notes = "获取该所有订单信息，返回的是OrderInfo对象集合",
            httpMethod = "get")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVO<List<OrderInfo>> initOrder(HttpSession session){
        String userId = (String) session.getAttribute("userId");
        List<OrderInfo> list = orderInfoService.listOrderInfoByUserId(userId);
        return success(list);
    }
}
