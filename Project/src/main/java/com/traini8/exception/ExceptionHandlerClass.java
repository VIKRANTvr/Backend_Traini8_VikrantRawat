package com.traini8.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

// Exception handler for handling application exceptions.

@RestControllerAdvice
public class ExceptionHandlerClass implements Serializable {

	private static final long serialVersionUID = 1L; // Added serialVersionUID

	public static class ResourceNotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public ResourceNotFoundException(String message) {
			super(message);
		}
	}

	// Handles ResourceNotFoundException and returns a structured error response.

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("status", HttpStatus.NOT_FOUND.value());
		errorResponse.put("error", "Resource Not Found");
		errorResponse.put("message", ex.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	// Handles all generic exceptions.

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleGlobalException(Exception ex) {
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.put("error", "Internal Server Error");
		errorResponse.put("message", ex.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}