package com.exception;
/**
 * 
 */
public class AccountNotFoundException extends Exception {

	
	private static final long serialVersionUID = 3331270062190373215L;
    
	public AccountNotFoundException(String message){
		super(message);
	}
}
