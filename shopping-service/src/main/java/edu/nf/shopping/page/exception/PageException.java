package edu.nf.shopping.page.exception;

/**
 * @author Bull fighters
 * @date 2020/3/12
 */
public class PageException extends RuntimeException{
    public PageException(Throwable cause) {
        super(cause);
    }

    public PageException(String message) {
        super(message);
    }

    public PageException(String message, Throwable cause) {
        super(message, cause);
    }
}