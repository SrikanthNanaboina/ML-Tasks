package com.bhavna.restdemo.service;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bhavna.restdemo.model.Employee;
import com.bhavna.restdemo.repository.EmployeeRepository;


@Service
@Transactional
public class EmployeeServiceImpl  implements EmployeeService{
	
	// Implementing Constructor based DI
	private EmployeeRepository repository;
	
	public EmployeeServiceImpl() {
		
	}
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository repository) {
		super();
		this.repository = repository;
	}
	
	
	@Override
	public List<Employee> getAllActiveEmployees() {
		List<Employee> list = new ArrayList<>();
		repository.findAll().forEach(e ->  list.add(e));
		return list;
	}

}
