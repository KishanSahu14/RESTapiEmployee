package com.springEmp.springBoot.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.springEmp.springBoot.GlobalLogger.GlobLog;
import com.springEmp.springBoot.controller.MyController;

@RestControllerAdvice
public class ExpHandler {
	
	private Logger logger = GlobLog.getLogger(MyController.class);
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex){
		
		logger.info("Exception Handler Called");
		
		Map<String,String> errorMap=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			
			errorMap.put(error.getField(), error.getDefaultMessage());
			
		});
		
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public Map<String, String> handleEmployeeNotFound(EmployeeNotFoundException ex) {
	    logger.info("EmployeeNotFoundException Handler Called");
	    
	    Map<String, String> errorMap = new HashMap<>();
	    errorMap.put("message", ex.getMessage());
	    
	    return errorMap;
	}

	
}