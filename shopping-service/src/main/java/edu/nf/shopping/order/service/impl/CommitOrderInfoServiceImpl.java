package edu.nf.shopping.order.service.impl;

import edu.nf.shopping.config.RabbitConfig;
import edu.nf.shopping.order.config.OrderRabbitConfig;
import edu.nf.shopping.order.dao.OrderDao;
import edu.nf.shopping.order.dao.OrderDetailsDao;
import edu.nf.shopping.order.entity.OrderInfo;
import edu.nf.shopping.order.exception.OrderException;
import edu.nf.shopping.order.service.CommitOrderInfoService;
import edu.nf.shopping.order.service.OrderInfoService;
import edu.nf.shopping.user.dao.UserAddressDao;
import edu.nf.shopping.user.entity.UserAddress;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Achine
 * @date 2020/4/9
 */
@Service("commitOrderInfoService")
public class CommitOrderInfoServiceImpl implements CommitOrderInfoService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserAddressDao userAddressDao;

    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 提交订单，并开启延迟消费
     * @param orderId
     * @param addressId
     * @return
     */
    @Override
    public OrderInfo commitOrderInfo(String orderId, String addressId) {
        try {
            OrderInfo orderInfo = checkOrder(orderId);
            orderInfo.setOrderDetails(orderDetailsDao.listOrderDetailsByOrderId(orderId));
            UserAddress address = checkAddress(addressId);
            //录入订单的收货信息
            orderInfo.setAddressRegion(address.getCity());
            orderInfo.setAddressName(address.getAddressName());
            orderInfo.setAddressTel(address.getAddressTel());
            orderInfo.setAddressUser(address.getAddressName());
            //修改真正的创建时间
            orderInfo.setCreateTime(new Date());
            //修改订单状态
            orderInfo.setOrderState("待付款");
            sendCommitOrder(orderInfo);
            sendDestroyOrder(orderInfo, 1800000);
            return orderInfo;
        }catch (Exception e){
            throw new OrderException(e);
        }
    }

    private OrderInfo checkOrder(String orderId){
        if(orderId == null || orderId == ""){
            throw new OrderException("订单编号不能为空");
        }
        OrderInfo orderInfo = orderDao.getOrderInfoByOrderId(orderId);
        if(orderInfo == null){
            throw new OrderException("该订单信息不存在");
        }
        if (orderInfo.getOrderState() == "已失效"){
            throw new OrderException("该订单已失效");
        }
        return orderInfo;
    }

    private UserAddress checkAddress(String addressId){
        if(addressId == null || addressId == ""){
            throw new OrderException("用户地址编号不能为空");
        }
        UserAddress address = userAddressDao.getUserAddressByAddrssId(addressId);
        if(address == null){
            throw new OrderException("该地址不存在");
        }
        return address;
    }

    /**
     * 发送提交订单
     * @param orderInfo 订单信息对象
     */
    private void sendCommitOrder(OrderInfo orderInfo){
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(orderInfo.getOrderId());
        orderDao.updateOrderInfo(orderInfo);
        //订单明细添加到数据库
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, OrderRabbitConfig.ORDER_COMMIT_ROUTER_KEY, orderInfo, correlationData);
    }

    /**
     * 发送销毁订单（设置订单失效）信息
     * @param orderInfo 订单对象
     * @param delayTime 延迟时间
     */
    private void sendDestroyOrder(OrderInfo orderInfo, Integer delayTime){
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(orderInfo.getOrderId());
        //延迟消费，当订单在三十分钟内不创建，则状态为（确认中），延迟消费会将状态修改为已失效
        rabbitTemplate.convertAndSend(RabbitConfig.DELAY_EXCHANGE_NAME, OrderRabbitConfig.ORDER_DESTROY_ROUTER_KEY, orderInfo, message -> {
            //设置延迟时间
            message.getMessageProperties().setDelay(delayTime);
            return message;
        }, correlationData);
    }
}
