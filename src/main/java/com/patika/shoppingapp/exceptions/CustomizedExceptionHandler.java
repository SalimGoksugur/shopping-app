package com.patika.shoppingapp.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.patika.shoppingapp.response.RestErrorResponse;
import com.patika.shoppingapp.response.RestResponse;

@RestController
@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler
	public final ResponseEntity<Object> HandleItemNotFoundException(ItemNotFoundException ex, WebRequest webRequest ) {
		
		String message = ex.getMessage();
		String detail = webRequest.getDescription(false);
		return getResponseEntity(message, detail, HttpStatus.NOT_FOUND );	
	}

	private ResponseEntity<Object> getResponseEntity(String message, String detail, HttpStatus httpStatus) {
		
		Date errorDate = new Date();
		RestErrorResponse restErrorResponse = new RestErrorResponse(errorDate, message, detail);
		RestResponse restResponse =  RestResponse.error(restErrorResponse);
		ResponseEntity<Object> responseEntity = new ResponseEntity<>(restResponse, httpStatus);
	    return responseEntity;
	}

}
