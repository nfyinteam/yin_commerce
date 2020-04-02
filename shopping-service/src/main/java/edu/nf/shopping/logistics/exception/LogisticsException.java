package edu.nf.shopping.logistics.exception;

/**
 * @author lishun
 * @date 2020/4/3
 */
public class LogisticsException extends RuntimeException {
    public LogisticsException(String message) {
        super(message);
    }

    public LogisticsException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogisticsException(Throwable cause) {
        super(cause);
    }
}
