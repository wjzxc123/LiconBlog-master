package com.Licon.blog.website.exception;

/**
 * 自定义异常
    * @ClassName: TipException  
    * @Description: TODO  
    * @author Licon  
    * @date 2018年11月15日  
    *
 */
public class TipException extends RuntimeException {

    public TipException() {
    }

    public TipException(String message) {
        super(message);
    }

    public TipException(String message, Throwable cause) {
        super(message, cause);
    }

    public TipException(Throwable cause) {
        super(cause);
    }

}
