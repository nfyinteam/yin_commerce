package edu.nf.shopping.user.advice;
import edu.nf.shopping.vo.ResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangl
 * @date 2019/11/11
 */
@ControllerAdvice("edu.nf.shopping.user.controller")
public class ExceptionAdvice {

    @ExceptionHandler(LoginException.class)
    @ResponseBody
    public ResponseVO loginException(LoginException e){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.UNAUTHORIZED.value());
        vo.setMessage(e.getMessage());
        return vo;
    }

    /**
     * 校验异常信息，当校验不通过时，Spring会抛出BindException异常,
     * 这个异常类继承Exception，同时还实现了BindingResult接口，
     * 之前在控制器方法中定义的BindingResult参数时，传入的也是
     * BindException对象
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseVO  validException(BindException e){
        ResponseVO vo = new ResponseVO();
        Map<String,String> message = new HashMap<>();
        for (FieldError error : e.getFieldErrors()) {
            System.out.println(error.getDefaultMessage());
            message.put(error.getField(), error.getDefaultMessage());
        }
        vo.setCode(1000);
        vo.setMessage(message);
        return vo;
    }
}
