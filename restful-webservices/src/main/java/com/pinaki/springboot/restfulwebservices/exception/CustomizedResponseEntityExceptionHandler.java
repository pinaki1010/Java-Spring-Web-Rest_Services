package com.pinaki.springboot.restfulwebservices.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pinaki.springboot.restfulwebservices.User.UserNotFoundException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDeatils> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		ErrorDeatils errorDetails = new ErrorDeatils(LocalDateTime.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDeatils>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
 
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDeatils> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ErrorDeatils errorDetails = new ErrorDeatils(LocalDateTime.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDeatils>(errorDetails, HttpStatus.NOT_FOUND);
		
	}
	
	

}
