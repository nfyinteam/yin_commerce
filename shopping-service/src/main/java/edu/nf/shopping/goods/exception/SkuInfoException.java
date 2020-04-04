package edu.nf.shopping.goods.exception;

/**
 * @author Achine
 * @date 2020/4/2
 */
public class SkuInfoException extends RuntimeException {
    public SkuInfoException(String message) {
        super(message);
    }

    public SkuInfoException(String message, Throwable cause) {
        super(message, cause);
    }

    public SkuInfoException(Throwable cause) {
        super(cause);
    }
}
