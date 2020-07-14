package com.emp.mgmt.exception;

public class EmployeeNotFoundException extends RuntimeException{
	
	public EmployeeNotFoundException(int id) {
		super("No Employee Info found for "+id);
	}
	public EmployeeNotFoundException(String deptName) {
		super("No Employee Info Found on deptName :"+deptName);
	}

}
