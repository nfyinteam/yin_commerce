package edu.nf.shopping.warehouse.advice;

import edu.nf.shopping.goods.exception.GoodsException;
import edu.nf.shopping.vo.ResponseVO;
import edu.nf.shopping.warehouse.controller.CargoInfoController;
import edu.nf.shopping.warehouse.exception.WarehouseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lishun
 * @date 2020/3/31
 */
@ControllerAdvice("edu.nf.shopping.warehouse.controller")
public class ControllerAspect {
    @ExceptionHandler(WarehouseException.class)
    @ResponseBody
    public ResponseVO loginException(GoodsException e){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }
}
