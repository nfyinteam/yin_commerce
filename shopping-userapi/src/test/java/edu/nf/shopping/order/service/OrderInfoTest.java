package edu.nf.shopping.order.service;

import edu.nf.shopping.order.entity.OrderInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Achine
 * @date 2020/4/10
 */
@SpringBootTest
public class OrderInfoTest {

    @Autowired
    private OrderInfoService orderInfoService;

    @Test
    public void listOrderInfoTest(){
        List<OrderInfo> list = orderInfoService.listOrderInfoByUserId("1578412688888");
        for (OrderInfo order : list){
            System.out.println(order.getOrderId());
        }
    }
}
