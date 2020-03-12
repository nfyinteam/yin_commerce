package edu.nf.shopping.comment.exception;

/**
 * @author Bull fighters
 * @date 2020/3/12
 */
public class CommentException extends RuntimeException{
    public CommentException(Throwable cause) {
        super(cause);
    }

    public CommentException(String message) {
        super(message);
    }

    public CommentException(String message, Throwable cause) {
        super(message, cause);
    }
}