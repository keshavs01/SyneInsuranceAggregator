package com.synechron.insurancecompany.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class InsuranceExceptions extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> customException(Exception ex, WebRequest request) {
		String message = "Exception occured";
		
		ApiExceptoin exceptionMessage = new ApiExceptoin(HttpStatus.INTERNAL_SERVER_ERROR, message, ex);
		
		return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
//	@ExceptionHandler(value = {HttpMessageNotReadableException.class})
//	public ResponseEntity<Object> customValidationException(HttpMessageNotReadableException ex, WebRequest request) {
//		String message = "Exception occured";
//		
//		ApiExceptoin exceptionMessage = new ApiExceptoin(HttpStatus.INTERNAL_SERVER_ERROR, message, ex);
//		
//		return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//		
//	}

}
