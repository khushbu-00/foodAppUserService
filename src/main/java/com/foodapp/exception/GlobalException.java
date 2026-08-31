package com.foodapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


	@RestControllerAdvice
	public class GlobalException {
		
		@ExceptionHandler(InvalidUserDataException.class)
		public ResponseEntity<String> handleInvalidUserData(InvalidUserDataException ex){
			return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
		}

		
		@ExceptionHandler(UserNotFoundException.class)
		public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex){
			return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
		}
	}

