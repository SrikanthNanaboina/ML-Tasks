package com.bhavna.exceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
//	@ExceptionHandler(ResourceNotFoundException.class)
//	  public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
//	    ErrorMessage message = new ErrorMessage(
//	        HttpStatus.NOT_FOUND.value(),
//	        new Date(),
//	        ex.getMessage(),
//	        request.getDescription(false));
//	    
//	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
//	  }

}
