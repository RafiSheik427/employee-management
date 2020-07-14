package com.cts.emp.mgmt.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.emp.mgmt.exception.AddingEmployeeInfofailedException;
import com.emp.mgmt.exception.EmployeeNotFoundException;
import com.emp.mgmt.exception.UpdatingEmployeeInfoException;

@ControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler(value=EmployeeNotFoundException.class)
	public ResponseEntity<?> handleEmployeeNotFoundException(EmployeeNotFoundException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=UpdatingEmployeeInfoException.class)
	public ResponseEntity<?> handleUpdatingEmployeeInfoExcpetion(UpdatingEmployeeInfoException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(value=AddingEmployeeInfofailedException.class)
	public ResponseEntity<?> handleAddingEmployeefailedException(AddingEmployeeInfofailedException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exception){
		return new ResponseEntity<>("failed",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
