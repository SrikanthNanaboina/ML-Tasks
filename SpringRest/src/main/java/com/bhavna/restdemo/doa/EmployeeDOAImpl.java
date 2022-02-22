package com.bhavna.restdemo.doa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.bhavna.restdemo.model.Employee;
import com.bhavna.restdemo.model.EmployeeMapper;


@Component
public abstract class EmployeeDOAImpl implements EmployeeDOA {
	private final String SQL_GET_ALL = "SELECT * FROM EMPLOYEE";
	private final String SQL_GET_ALL_ACTIVE = "SELECT * FROM EMPLOYEE WHERE STATUS = 'Active'";
	
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//
//	@Override
//	public List<Employee> getAllEmployees() {
//		return jdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
//	}
//
//	@Override
//	public List<Employee> getAllActiveEmployees() {
//		return jdbcTemplate.query(SQL_GET_ALL_ACTIVE, new EmployeeMapper());
//	}

}
