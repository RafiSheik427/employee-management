package com.cts.emp.mgmt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.emp.mgmt.service.EmployeeMgmtService;
import com.emp.mgmt.dto.EmployeeDto;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(path = "/api/empmgmt/")
@Log4j2
public class EmployeeMgmtController {

	@Autowired
	private EmployeeMgmtService empService;

	@GetMapping(value = "/{departmentName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getEmployeesByDept(@RequestParam(name = "deptName", required = true) String deptName) {
		log.info("entered into getEmployeesByDept() with dpmtName : {}", deptName);
		List<EmployeeDto> empInfoBasedOnDept = empService.getEmployeesByDept(deptName);

		return new ResponseEntity<List<EmployeeDto>>(empInfoBasedOnDept, HttpStatus.OK);

	}

	@GetMapping(value = "/allemployess")
	public ResponseEntity<?> getAllEmployees() {

		log.info("enter into getAllEmployees()");
		List<EmployeeDto> allEmpInfo = empService.getAllEmployees();
		return new ResponseEntity<>(allEmpInfo, HttpStatus.OK);

	}

	@PostMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addEmployee(@Valid EmployeeDto emp) {
		log.info("Adding employee info :{}", emp.toString());
		empService.addEmployee(emp);
		return new ResponseEntity<>("Added Employee info successfully", HttpStatus.OK);

	}

	@PutMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateEmployee(@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "salary", required = true) double salary) {
		log.info("updating employee salary : {} for Id : {}", salary, id);
		empService.updateEmployee(id, salary);
		return new ResponseEntity<>("updated employee salary succesfully for employee id:" + id, HttpStatus.OK);
	}

}
