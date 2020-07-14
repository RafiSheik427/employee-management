package com.emp.mgmt.exception;

public class UpdatingEmployeeInfoException extends RuntimeException{
	public UpdatingEmployeeInfoException(int id) {
		super("failed to update employee info for empid:"+id);
	}

}
