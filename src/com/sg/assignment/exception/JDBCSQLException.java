package com.sg.assignment.exception;

public class JDBCSQLException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JDBCSQLException(){
		super();
	}
	
	public JDBCSQLException(String message) {
		super(message);
		
	}
}
