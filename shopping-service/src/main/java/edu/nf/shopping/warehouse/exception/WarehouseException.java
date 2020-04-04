package edu.nf.shopping.warehouse.exception;

/**
 * @author lishun
 * @date 2020/3/31
 */
public class WarehouseException extends RuntimeException {
    public WarehouseException(String message) {
        super(message);
    }

    public WarehouseException(String message, Throwable cause) {
        super(message, cause);
    }

    public WarehouseException(Throwable cause) {
        super(cause);
    }
}
