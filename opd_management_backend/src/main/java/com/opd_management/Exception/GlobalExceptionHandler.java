package com.opd_management.Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.opd_management.Response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	//Resource Not Found 
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> HandleResourceNotFound(ResourceNotFoundException ex){
		
		ErrorResponse errorResponse = new ErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),
				LocalDateTime.now());
		
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	// Validation Errors
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> HandleValidationErrors(MethodArgumentNotValidException ex){
		
		Map<String,String> errors = new HashMap<>();
		
		ex.getBindingResult()
		.getFieldErrors()
		.forEach(error ->
			errors.put(error.getField(), error.getDefaultMessage())
		);
		
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
	
	//Database Errors
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<ErrorResponse> HandleDatabaseException(DataBaseException ex){
		
		ErrorResponse errorResponse = new ErrorResponse(
				HttpStatus.SERVICE_UNAVAILABLE.value(),
				ex.getMessage(),
				LocalDateTime.now());
		
		return new ResponseEntity<>(errorResponse ,HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	//Duplicate Entry errors
	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<ErrorResponse> HandleDuplicateException(DuplicateResourceException ex){
		
		ErrorResponse errorResponse = new ErrorResponse(
				HttpStatus.CONFLICT.value(),
				ex.getMessage(),
				LocalDateTime.now());
		
		return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
	}
	
	//Fallback Exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> HandleGenericException(Exception ex){
		
		ErrorResponse errorResponse = new ErrorResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Something Went Wrong",
				 LocalDateTime.now());
		
		return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
