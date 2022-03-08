package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.model.Employee;
import com.bhavna.model.EmployeePage;
import com.bhavna.service.EmployeeService;



@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	@PostMapping("/Employee")
	public Employee addStudent(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	
	@GetMapping("/Employee/{id}")
	public Employee getEmployeeById(@PathVariable(name="id") Long id) {
		return service.getEmployeeById(id);
	}
	
	@PutMapping("/Employee")
	public void updateEmployee(@RequestBody Employee employee) {
		service.updateEmployee(employee);
	}
	
	@DeleteMapping("/Employee/{id}")
	public void deleteEmployee(@PathVariable(name="id") Long id) {
		service.deleteEmployeeById(id);
	}
	
	@GetMapping("/Employees")
	public EmployeePage getEmployees(@RequestParam(name="page", required=false, defaultValue = "0")Integer page,
										@RequestParam(name="size", required=false, defaultValue = "10") Integer size) {
		return service.getAllEmployees(page,size);
	}
	
}
