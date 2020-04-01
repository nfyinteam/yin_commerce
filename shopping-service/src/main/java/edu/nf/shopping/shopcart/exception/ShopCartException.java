package edu.nf.shopping.shopcart.exception;

/**
 * @author Vera
 * @date 2020/3/24
 */
public class ShopCartException extends RuntimeException {
    public ShopCartException(String message) {
        super(message);
    }

    public ShopCartException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShopCartException(Throwable cause) {
        super(cause);
    }
}
