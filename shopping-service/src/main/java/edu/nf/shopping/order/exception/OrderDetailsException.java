package edu.nf.shopping.order.exception;

/**
 * @author Achine
 * @date 2020/4/6
 */
public class OrderDetailsException extends RuntimeException {
    public OrderDetailsException(String message) {
        super(message);
    }

    public OrderDetailsException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderDetailsException(Throwable cause) {
        super(cause);
    }
}
