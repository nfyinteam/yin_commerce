package edu.nf.shopping.vo;

import org.springframework.http.HttpStatus;

/**
 * @author Bull fighters
 * @date 2019/12/1
 */
public class BaseController {

    protected ResponseVO fail(Integer code,Object message){
        ResponseVO vo=new ResponseVO();
        vo.setCode(code);
        vo.setMessage(message);
        return vo;
    }

    protected ResponseVO fail(Integer code){
        ResponseVO vo=new ResponseVO();
        vo.setCode(code);
        return vo;
    }

    protected <T> ResponseVO<T> success(T data){
        ResponseVO<T> vo=new ResponseVO();
        vo.setCode(HttpStatus.OK.value());
        vo.setData(data);
        return vo;
    }

    protected ResponseVO success(Integer code,Object message){
        ResponseVO vo=new ResponseVO();
        vo.setCode(code);
        vo.setMessage(message);
        return vo;
    }
}