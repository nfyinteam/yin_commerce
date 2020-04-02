package edu.nf.shopping.user.exception;

/**
 * @author wangl
 * @date 2019/11/11
 * 自定义登陆异常
 */
public class UserException extends RuntimeException{

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }
}
