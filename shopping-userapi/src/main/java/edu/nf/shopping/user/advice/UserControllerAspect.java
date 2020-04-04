package edu.nf.shopping.user.advice;

import edu.nf.shopping.goods.exception.GoodsException;
import edu.nf.shopping.user.exception.UserException;
import edu.nf.shopping.vo.ResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Vera
 * @date 2020/4/2
 */
public class UserControllerAspect {

    @ExceptionHandler(UserException.class)
    @ResponseBody
    public ResponseVO loginException(UserException e){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }
}
