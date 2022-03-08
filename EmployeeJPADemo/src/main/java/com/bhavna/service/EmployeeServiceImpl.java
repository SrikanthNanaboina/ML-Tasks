package com.bhavna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bhavna.model.Employee;
import com.bhavna.model.EmployeePage;
import com.bhavna.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository repo;

	@Override
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}
	
	@Override
	public EmployeePage getAllEmployees(Integer page, Integer size) {
		EmployeePage employeePage = new EmployeePage();
		Page<Employee> ePage= repo.findAll(PageRequest.of(page, size));
		employeePage.setCurrentPage(page);
		employeePage.setTotalEmployees(ePage.getTotalElements());
		employeePage.setTotalPages(ePage.getTotalPages());
		employeePage.setEmployees(ePage.toList());;
		return employeePage;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return repo.findById(id).orElseThrow();
	}

	@Override
	public void deleteEmployeeById(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		repo.save(employee);	
	}

}
