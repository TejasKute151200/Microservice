package com.microservice.response;

public class FileUploadingResponse {

	private String message;


	public FileUploadingResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
