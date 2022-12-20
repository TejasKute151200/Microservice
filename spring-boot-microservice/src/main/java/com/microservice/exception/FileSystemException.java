package com.microservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.microservice.response.FileUploadingResponse;

@ControllerAdvice
public class FileSystemException extends ResponseEntityExceptionHandler{

    @ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<FileUploadingResponse> handleMaxSizeException(MaxUploadSizeExceededException exc){
    	return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileUploadingResponse("File to large !"));
    }
}
