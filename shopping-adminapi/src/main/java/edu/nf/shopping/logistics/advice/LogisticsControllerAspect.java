package edu.nf.shopping.logistics.advice;

import edu.nf.shopping.goods.exception.GoodsException;
import edu.nf.shopping.logistics.exception.LogisticsException;
import edu.nf.shopping.vo.ResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lishun
 * @date 2020/4/3
 */
@ControllerAdvice({"edu.nf.shopping.logistics.controller"})
public class LogisticsControllerAspect {
    @ExceptionHandler(LogisticsException.class)
    @ResponseBody
    public ResponseVO loginException(LogisticsException e){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }
}
