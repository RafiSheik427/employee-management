package com.cts.emp.mgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.mgmt.dto.EmployeeDto;

@Service
public interface EmployeeMgmtService {

	List<EmployeeDto> getAllEmployees();
	List<EmployeeDto> getEmployeesByDept(String departmentName);
	void updateEmployee(int id,double salary);
	void addEmployee(EmployeeDto employee);
}
