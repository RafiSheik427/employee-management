package com.cts.emp.mgmt.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue
	public int id;
	public String empName;
	public String address;
	public Date dateOfJoining;
	public Date dateOfBirth;
	public String department;
	public double salary;
	
	

}
