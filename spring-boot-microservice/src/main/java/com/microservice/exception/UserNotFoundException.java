package com.microservice.exception;

public class UserNotFoundException extends Exception{

	/**
	 * Created By TejTechWorld
	 */
	
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException (long id){
		super(String.format("User not found with Id "+id));
		
	}
}
