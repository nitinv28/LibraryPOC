package com.genpect.libraries.exception;

import org.springframework.http.HttpStatus;

/**
 * this class is used to handle all the runtime exceptions
 */
public class CustomException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String description;
	private HttpStatus httpStatus;
	
	public CustomException(String description,  HttpStatus httpStatus) {
		super();
		this.description = description;
		this.httpStatus =httpStatus;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}
