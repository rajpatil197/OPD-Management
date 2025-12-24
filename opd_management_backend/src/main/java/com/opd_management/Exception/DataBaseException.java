package com.opd_management.Exception;

public class DataBaseException extends RuntimeException{

	public DataBaseException(String message) {
		super(message);
	}
	
	public DataBaseException(String message,Throwable cause) {
		super(message, cause);
	}
}
