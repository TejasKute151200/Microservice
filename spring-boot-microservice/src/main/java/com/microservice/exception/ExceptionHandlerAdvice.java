package com.microservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerAdvice {
		
@ResponseBody
@ExceptionHandler(UserNotFoundException.class)
@ResponseStatus(value = HttpStatus.NOT_FOUND)
	String UserNotFoundExceptionHandler(UserNotFoundException e){
	
		return e.getMessage();
	}

}
