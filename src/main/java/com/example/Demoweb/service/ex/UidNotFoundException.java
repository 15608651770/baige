package com.example.Demoweb.service.ex;

/**
 * 用户数据不存在的异常
 */
public class UidNotFoundException extends ServiceException {

    private static final long serialVersionUID = 7760035279340840793L;

    public UidNotFoundException() {
		super();
	}

	public UidNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UidNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UidNotFoundException(String message) {
		super(message);
	}

	public UidNotFoundException(Throwable cause) {
		super(cause);
	}

}
