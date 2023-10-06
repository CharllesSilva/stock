package com.charlles.stock.exceptions.handler;

import java.util.Date;

import com.charlles.stock.exceptions.ExceptionResponse;
import com.charlles.stock.exceptions.InvalidJwtAuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{



	@ExceptionHandler(InvalidJwtAuthenticationException.class)
	public final ResponseEntity<ExceptionResponse> handleInvalidJwtAuthenticationExceptions(
			Exception ex, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
	}

}
