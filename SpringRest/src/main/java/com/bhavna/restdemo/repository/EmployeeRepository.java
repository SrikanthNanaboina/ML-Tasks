package com.bhavna.restdemo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.bhavna.restdemo.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	@Query(value="SELECT * FROM EMPLOYEE WHERE STATUS = 'Active'",  nativeQuery = true)
	public List<Employee> getActiveEmployees();

}
