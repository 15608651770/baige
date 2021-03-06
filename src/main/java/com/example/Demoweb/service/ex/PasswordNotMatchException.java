package com.example.Demoweb.service.ex;

/**
 * 密码不匹配的异常
 */
public class PasswordNotMatchException extends ServiceException {
    
    private static final long serialVersionUID = -9129207421492525412L;

    public PasswordNotMatchException() {
		super();
	}

	public PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PasswordNotMatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public PasswordNotMatchException(String message) {
		super(message);
	}

	public PasswordNotMatchException(Throwable cause) {
		super(cause);
	}

}
