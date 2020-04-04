package edu.nf.shopping.goods.exception;

/**
 * @author Achine
 * @date 2020/4/2
 */
public class ImgsInfoException extends RuntimeException {
    public ImgsInfoException(String message) {
        super(message);
    }

    public ImgsInfoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImgsInfoException(Throwable cause) {
        super(cause);
    }
}
