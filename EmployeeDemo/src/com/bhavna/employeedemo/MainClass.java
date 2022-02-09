package com.bhavna.employeedemo;

public class MainClass {
	public static void main(String[] args) {
		System.out.println("No of Employees with name starting with S");
		System.out.println( EmployeeList.countOfEmployeesStartWithS());
		
		System.out.println("Employees from Hyderbad");
		EmployeeList.printEmployeesFromHyd();
		
		System.out.println("Employees list based on location");
		System.out.println(EmployeeList.getEmployeesFromLocation());
		
		System.out.println("Check if any Employee have more salary than 10000");
		EmployeeList.check();
		
		System.out.println("Sort by Name");
		System.out.println(EmployeeList.sortByName());
		
		System.out.println("Sort by Location");
		System.out.println(EmployeeList.sortByLocation());
	}
}
