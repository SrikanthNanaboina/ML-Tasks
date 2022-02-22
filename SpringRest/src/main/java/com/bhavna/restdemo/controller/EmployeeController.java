package com.bhavna.restdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.restdemo.doa.EmployeeDOA;
import com.bhavna.restdemo.model.Employee;
import com.bhavna.restdemo.service.EmployeeService;

@RestController
public class EmployeeController {
//	@Autowired
//	EmployeeDOA doa;
	
	@Autowired
	EmployeeService service;
	
    @RequestMapping(value = "/getActiveEmployees", method = RequestMethod.GET  ) //, produces={MediaType.APPLICATION_JSON_VALUE})
    public List<Employee> getActiveEmployees() {
        return service.getAllActiveEmployees();
    }
    
    @RequestMapping(value = "/test", method = RequestMethod.GET  ) //, produces={MediaType.APPLICATION_JSON_VALUE})
    public String getTest() {
        return "Hello";
    }
}