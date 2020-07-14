package com.emp.mgmt.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
public class EmployeeDto implements Serializable {

	public int id;
	@NotNull
	public String empName;
	@NotNull
	public String address;
	public Date dateOfBirth;
	public Date dateOfJoining;
	@NotNull
	public String department;
	public double salary;
	

}
