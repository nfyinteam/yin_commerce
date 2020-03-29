package edu.nf.shopping.user.exception;

/**
 * @author wangl
 * @date 2019/11/11
 * 自定义登陆异常
 */
public class LoginException extends RuntimeException{

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException(Throwable cause) {
        super(cause);
    }
}
