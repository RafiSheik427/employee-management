package com.emp.mgmt.exception;

public class AddingEmployeeInfofailedException extends RuntimeException {
	
	public AddingEmployeeInfofailedException() {
		super("failed to add employee info");
	}

}
