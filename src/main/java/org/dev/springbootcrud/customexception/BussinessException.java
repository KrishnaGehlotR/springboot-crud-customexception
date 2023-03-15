package org.dev.springbootcrud.customexception;

import org.springframework.stereotype.Component;

@Component
public class BussinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3708795217622498137L;

	private String errorCode;
	private String errorMessages;

	public BussinessException() {

	}

	public BussinessException(String errorCode, String errorMessages) {
		super();
		this.errorCode = errorCode;
		this.errorMessages = errorMessages;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
