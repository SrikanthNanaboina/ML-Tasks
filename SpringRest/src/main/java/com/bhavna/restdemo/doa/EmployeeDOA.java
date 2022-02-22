package com.bhavna.restdemo.doa;

import java.util.List;

import com.bhavna.restdemo.model.Employee;

public interface EmployeeDOA {
	List<Employee> getAllEmployees();
	List<Employee> getAllActiveEmployees();
}
