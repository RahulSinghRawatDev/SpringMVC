package com.learning.app.ws.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.learning.app.ws.ui.model.response.ErrorMessage;
import com.learning.app.ws.ui.model.response.ErrorMessages;

@ControllerAdvice
public class AppExceptionHandler {
	
	
	
	// specific exceptions
	@ExceptionHandler(value = {UserServiceExceptions.class})
	public ResponseEntity<Object> handleUserServiceException(UserServiceExceptions ex,WebRequest request)
	{
		
		ErrorMessage errorMessages = new ErrorMessage(new Date(),ex.getMessage());
	 
		return new ResponseEntity<>(errorMessages,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	  // All exceptions
	  
	  @ExceptionHandler(value = {Exception.class}) public ResponseEntity<Object>
	  handleOtherException(Exception ex,WebRequest request) {
	  
	  ErrorMessage errorMessages = new ErrorMessage(new Date(),ex.getMessage());
	  
	  return new ResponseEntity<>(errorMessages,new
	  HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR); }
	 
}