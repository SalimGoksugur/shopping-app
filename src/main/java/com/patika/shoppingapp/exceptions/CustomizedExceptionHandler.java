package com.patika.shoppingapp.exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
		List<String> detail = new ArrayList<String>();
		detail.add( webRequest.getDescription(false));
		return getResponseEntity(message, detail, HttpStatus.NOT_FOUND );	
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, 
										HttpHeaders headers, HttpStatus status, WebRequest request) {
		 
		 String message = "Validation failed!";
	     List<String> messageDetail = new ArrayList<String>();
	     List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
         for (ObjectError objectError : errorList) {
             String defaultMessage = objectError.getDefaultMessage();
             messageDetail.add(defaultMessage) ;
         }
     return getResponseEntity(message, messageDetail, HttpStatus.BAD_REQUEST);
		
	}
	
	

	private ResponseEntity<Object> getResponseEntity(String message, List<String> detail, HttpStatus httpStatus) {
		
		Date errorDate = new Date();
		RestErrorResponse restErrorResponse = new RestErrorResponse(errorDate, message, detail);
		RestResponse<RestErrorResponse> restResponse =  RestResponse.error(restErrorResponse);
		ResponseEntity<Object> responseEntity = new ResponseEntity<>(restResponse, httpStatus);
	    return responseEntity;
	}

}
