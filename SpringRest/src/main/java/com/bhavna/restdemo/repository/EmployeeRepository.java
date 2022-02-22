package com.bhavna.restdemo.repository;



import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.bhavna.restdemo.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{



}
