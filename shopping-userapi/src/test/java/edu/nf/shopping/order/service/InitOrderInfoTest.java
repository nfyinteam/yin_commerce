package edu.nf.shopping.order.service;

import edu.nf.shopping.order.entity.OrderDetails;
import edu.nf.shopping.order.entity.OrderInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Achine
 * @date 2020/4/7
 */
@SpringBootTest
public class InitOrderInfoTest {
    @Autowired
    private InitOrderInfoService orderInfoService;

    @Test
    public void initOrder(){
        //用户编号
        String userId = "1578412688888";
        //购物消息
        OrderDetails details1 = new OrderDetails();
        OrderDetails details2 = new OrderDetails();
        //商品的sku编号
        details1.setSkuId("1577706998234");
        details2.setSkuId("1577706998245");
        //该商品的数量
        details1.setSkuNum(1);
        details2.setSkuNum(2);
        //创建订单明细信息集合
        List<OrderDetails> list = new ArrayList<>();
        list.add(details1);
        list.add(details2);
        //执行初始化方法
        OrderInfo orderInfo = orderInfoService.initOrderInfo(userId, list);
        if(orderInfo != null){
            System.out.println(orderInfo.getOrderId());
        }
    }
}
