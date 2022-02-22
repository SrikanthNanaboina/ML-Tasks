package com.bhavna.restdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bhavna.restdemo.model.Employee;

@Service
public interface EmployeeService {
	public List<Employee> getAllActiveEmployees();
}
