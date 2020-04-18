package edu.nf.shopping.message.advice;

import edu.nf.shopping.message.exception.MessageException;
import edu.nf.shopping.vo.ResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Achine
 * @date 2019/11/14
 */
@ControllerAdvice({"edu.nf.shopping.message.controller"})
public class MessageControllerAspect {

    @ExceptionHandler(MessageException.class)
    @ResponseBody
    public ResponseVO loginException(MessageException e){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }

}
