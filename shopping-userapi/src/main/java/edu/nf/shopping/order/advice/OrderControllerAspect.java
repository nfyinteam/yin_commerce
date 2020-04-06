package edu.nf.shopping.order.advice;

import edu.nf.shopping.order.exception.OrderDetailsException;
import edu.nf.shopping.order.exception.OrderException;
import edu.nf.shopping.vo.ResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Achine
 * @date 2020/4/5
 */
@ControllerAdvice({"edu.nf.shopping.order.controller"})
public class OrderControllerAspect {

    @ExceptionHandler(OrderException.class)
    @ResponseBody
    public ResponseVO orderException(OrderException e){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }

    @ExceptionHandler(OrderDetailsException.class)
    @ResponseBody
    public ResponseVO orderDetailsException(OrderDetailsException e){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }
}
