package com.assess.util;

public class ResponseErrorClass extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public ResponseErrorClass(String message) {
	    this.message=message;	
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
}
