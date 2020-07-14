package com.cts.emp.mgmt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.emp.mgmt.entity.Employee;
import com.cts.emp.mgmt.repository.EmployeeMgmtRepository;
import com.emp.mgmt.dto.EmployeeDto;
import com.emp.mgmt.exception.AddingEmployeeInfofailedException;
import com.emp.mgmt.exception.EmployeeNotFoundException;
import com.emp.mgmt.exception.UpdatingEmployeeInfoException;

@Service
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {

	@Autowired
	EmployeeMgmtRepository empRepository;

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = (List<Employee>) empRepository.findAll();
		List<EmployeeDto> allEmployees = new ArrayList<EmployeeDto>();
		if (employees != null) {
			employees.forEach(emp -> {
				allEmployees.add(this.mapEmployeeToDto(emp));
			});
		}
		return allEmployees;
	}

	@Override
	public void updateEmployee(int id, double salary) {
		try {
			Employee emp = this.getEmployeeById(id);
			if (emp != null) {
				emp.setSalary(salary);
				empRepository.save(emp);
			}
		} catch (Exception e) {
			throw new UpdatingEmployeeInfoException(id);
		}

	}

	@Override
	public void addEmployee(EmployeeDto employeeDto) {
		try {
			empRepository.save(mapDtoToEntity(employeeDto));
		} catch (Exception e) {
			throw new AddingEmployeeInfofailedException();
		}
	}

	@Override
	public List<EmployeeDto> getEmployeesByDept(String departmentName) {
		try {
			return this.getAllEmployees().stream().filter(emp -> emp.getDepartment().equals(departmentName))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new EmployeeNotFoundException(departmentName);
		}

	}

	public Employee getEmployeeById(int id) {
		return empRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
	}

	private EmployeeDto mapEmployeeToDto(Employee emp) {

		EmployeeDto dto = new EmployeeDto();
		dto.setId(emp.getId());
		dto.setEmpName(emp.getEmpName());
		dto.setAddress(emp.getAddress());
		dto.setDateOfBirth(emp.getDateOfBirth());
		dto.setDateOfJoining(emp.getDateOfJoining());
		dto.setDepartment(emp.getDepartment());
		return dto;
	}

	private Employee mapDtoToEntity(EmployeeDto dto) {

		Employee emp = new Employee();
		emp.setEmpName(dto.getEmpName());
		emp.setAddress(dto.getAddress());
		emp.setDateOfBirth(dto.getDateOfBirth());
		emp.setDateOfJoining(dto.getDateOfJoining());
		emp.setSalary(dto.getSalary());
		return emp;
	}

}
