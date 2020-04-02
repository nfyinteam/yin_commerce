package edu.nf.shopping.goods.exception;

/**
 * @author Achine
 * @date 2020/4/2
 */
public class GoodsImgException extends RuntimeException {
    public GoodsImgException(String message) {
        super(message);
    }

    public GoodsImgException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoodsImgException(Throwable cause) {
        super(cause);
    }
}
