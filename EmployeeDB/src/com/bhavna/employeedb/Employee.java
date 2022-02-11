package com.bhavna.employeedb;

public class Employee {
	private long id;
	private String name;
	private double salary;
	private String dateOfJoin;
	private int deptId;
	
	
	public Employee(long id, String name, double salary, String dateOfJoin, int deptId) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dateOfJoin = dateOfJoin;
		this.deptId = deptId;
	}
	
	public Employee() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
}
