package com.bhavna.employeedemo;

public class Employee {
	private String name;
	private double salary;
	private String location;
	
	public Employee(String name, double salary, String location) {
		this.name = name;
		this.salary = salary;
		this.location = location;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", location=" + location + "]";
	}
	
	
	
}
