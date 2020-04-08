package edu.nf.shopping.message.exception;

/**
 * @author Achine
 * @date 2020/3/6
 */
public class MessageException extends RuntimeException {
    public MessageException(String message) {
        super(message);
    }

    public MessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageException(Throwable cause) {
        super(cause);
    }
}
