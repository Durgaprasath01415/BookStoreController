package com.bookstore.main.exceptions;

import lombok.Data;

@Data
public class BookExceptions extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private int StatusCode;
	private String StatusMessage;
	
	public BookExceptions(int statusCode, String statusMessage) {
		super();
		StatusCode = statusCode;
		StatusMessage = statusMessage;
	}
	
	
}
