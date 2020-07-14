package com.cts.emp.mgmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.emp.mgmt.entity.Employee;

@Repository
public interface EmployeeMgmtRepository extends CrudRepository<Employee, Integer> {

}
