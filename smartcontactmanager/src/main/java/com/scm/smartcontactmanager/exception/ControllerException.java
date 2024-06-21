package com.scm.smartcontactmanager.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public  ResponseEntity<ErrorDetails> handleAllException(ResourceNotFoundException cause, WebRequest webRequest){
		ErrorDetails error = new ErrorDetails(new Date(),cause.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);
	}

}
