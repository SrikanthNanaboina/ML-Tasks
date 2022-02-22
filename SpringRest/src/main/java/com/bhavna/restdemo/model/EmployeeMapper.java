package com.bhavna.restdemo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee e = new Employee();
		e.setId(rs.getLong("E_ID"));
		e.setName(rs.getString("E_NAME"));
		e.setDateOfJoining(rs.getString("DATE_OF_JOINING"));
		e.setDeptId(rs.getInt("DEPT_ID"));
		e.setSalary(rs.getDouble("SALARY"));
		e.setStatus(rs.getString("STATUS"));
		return e;
	}

}
