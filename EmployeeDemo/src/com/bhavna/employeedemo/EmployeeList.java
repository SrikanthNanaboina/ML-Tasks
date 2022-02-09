package com.bhavna.employeedemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class EmployeeList {
	static List<Employee> list = new ArrayList<>();
	static {
		list.add(new Employee("Srikanth", 25000, "Hyderbad"));
		list.add(new Employee("Ajay", 24000, "Noida"));
		list.add(new Employee("Hari", 28000.25,  "Hyderbad"));
		list.add(new Employee("Navya", 25009.7,  "Hyderbad"));
		list.add(new Employee("Mahi", 26000,  "Chennai"));
		list.add(new Employee("Vishal", 20000,  "Noida"));
		list.add(new Employee("Devi", 35000,  "Hyderbad"));
		list.add(new Employee("Sridhar", 34000,  "Chennai"));
	}
	
	
	public static Map<String, List<Employee>> getEmployeesFromLocation() {
		return  list.stream().collect(Collectors.groupingBy(Employee::getLocation));
	}
	
	
	public static int countOfEmployeesStartWithS() {
		return (int) list.stream().filter(e -> e.getName().toUpperCase().startsWith("S") ).count();
	}
	
	
	public static void printEmployeesFromHyd() {
		  list.stream().parallel().filter(e-> e.getLocation().equals("Hyderbad") ).forEach(System.out::println);
	}

	
	public static void check() {
		if(list.stream().parallel().anyMatch(e -> e.getSalary()>10000))
			System.out.println("Atleast one employee has more salary than 10000");
		else
			System.out.println("No employee has more salary than 10000");
	}
	
	
	public static List<Employee> sortByName() {
		return list.stream().sorted((e1,e2) -> e1.getName().compareToIgnoreCase(e2.getName())).collect(Collectors.toList());
	}
	
	
	public static List<Employee> sortByLocation() {
		return list.stream().sorted((e1,e2) -> e1.getLocation().compareToIgnoreCase(e2.getLocation())).collect(Collectors.toList());
	}
}
