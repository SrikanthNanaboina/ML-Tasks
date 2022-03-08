package com.bhavna.service;

import java.util.List;

import com.bhavna.model.Employee;
import com.bhavna.model.EmployeePage;


public interface EmployeeService {
	public Employee saveEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(Long id);
    public void deleteEmployeeById(Long id);
    public void updateEmployee(Employee employee);
	public EmployeePage getAllEmployees(Integer page, Integer size);
}
