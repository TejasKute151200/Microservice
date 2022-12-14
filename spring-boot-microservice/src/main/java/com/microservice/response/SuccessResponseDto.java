package com.microservice.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SuccessResponseDto {

	private String msgKey;
	private String message;
	private Object data;
	
}
