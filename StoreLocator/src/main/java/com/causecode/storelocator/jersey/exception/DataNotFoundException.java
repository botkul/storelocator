package com.causecode.storelocator.jersey.exception;

public class DataNotFoundException extends RuntimeException {
	public DataNotFoundException(){super();}
	
	public DataNotFoundException(String message){
		super(message);
	}
}
