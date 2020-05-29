package com.example.Demoweb.service.ex;

/**
 * 用户名冲突的异常
 */
public class UsernameDuplicateException extends ServiceException{

    private static final long serialVersionUID = -7306354357105474189L;

    public UsernameDuplicateException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UsernameDuplicateException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public UsernameDuplicateException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public UsernameDuplicateException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public UsernameDuplicateException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
    
    

}
