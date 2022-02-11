package com.bhavna.employeedb;

import java.util.Scanner;



public class MainClass {

	public static void main(String[] args) {
		EmployeeDB.connectToDB();
		char status = 'Y';
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Welcome, Select an option");
			System.out.println("1. Do you want to enter Employee record");
			System.out.println("2. Do you want to enter Department record");
			System.out.println("3. List all Employees");
			System.out.println("4. List all departments");
			System.out.println("5. Update employee detail with E_Id");
			System.out.println("6. Number of employees in each department whose employee salary  greater than 30000");
			System.out.println("7. Close SQL Connection");
			int option = scanner.nextInt();
			scanner.nextLine();
			switch (option) {
			case 1: {
				System.out.println("How many records do you want to enter");
				int n = scanner.nextInt();
				scanner.nextLine();
				for(int i=0; i<n; i++)
				{	
					Employee employee = new Employee();
					System.out.println("Enter Employee name");
					employee.setName(scanner.nextLine());
					System.out.println("Enter Employee ID");
					employee.setId(scanner.nextLong());
					scanner.nextLine();
					if(EmployeeDB.isEmployeePresent(employee.getId())) {
						System.out.println("EmployeeID "+employee.getId()+" is already present.");
						continue;
					}
					System.out.println("Enter Salary of Employee");
					employee.setSalary(scanner.nextInt());
					System.out.println("Enter DOJ as YYYY-MM-DD");
					employee.setDateOfJoin(scanner.next());
					scanner.nextLine();
					System.out.println("Enter Department ID to which employee belongs");
					int deptId = scanner.nextInt();
					scanner.nextLine();
					if(EmployeeDB.isDepartmentPresent(deptId))
					{
						employee.setDeptId(deptId);
						EmployeeDB.addEmployee(employee);
					}
					else
					{
						System.out.println("Invalid Department");
						System.out.println("Do you want to create a Department Y/N");
						status = scanner.nextLine().charAt(0);
						if(status == 'Y' || status == 'y' )
						{
							System.out.println("Enter Department name");
							String name = (scanner.nextLine());
							EmployeeDB.addDepartment(deptId,name);
							employee.setDeptId(deptId);
							EmployeeDB.addEmployee(employee);
						}
					}
				}
				System.out.println("Do you want to return to main menu Y/N");
				status = scanner.nextLine().charAt(0);
				break;
			}
			case 2: {
				System.out.println("How many records do you want to enter");
				int n = scanner.nextInt();
				scanner.nextLine();
				for(int i=0; i<n; i++)
				{
					System.out.println("Enter Department name");
					String name = scanner.nextLine();
					System.out.println("Enter Department ID");
					int deptId = scanner.nextInt();
					scanner.nextLine();
					if(EmployeeDB.isDepartmentPresent(deptId)) {
						System.out.println("DeptID "+deptId+" is already present.");
						continue;
					}
					EmployeeDB.addDepartment(deptId,name);
					
				}
				System.out.println("Do you want to return to main menu Y/N");
				status = scanner.nextLine().charAt(0);
				break;
			}
			case 3: {
				EmployeeDB.listEmployees();
				EmployeeDB.close();
				status='N';
				break;
			}
			case 4: {
				EmployeeDB.listDepartments();
				EmployeeDB.close();
				status='N';
				break;
			}
			
			case 5: {
				System.out.println("Enter Employee ID");
				long empId = scanner.nextLong();
				scanner.nextLine();
				Employee employee = EmployeeDB.getEmployee(empId);
				
				if(employee==null) {
					System.out.println("No employee with id "+empId);
					break;
				}
				
				System.out.println("Select an option to update");
				System.out.println("1. Name");
				System.out.println("2. Salary");
				System.out.println("3. DOJ");
				System.out.println("4. Department Id");
				
				int updateOption = scanner.nextInt();
				scanner.nextLine();
				
				switch(updateOption) {
					case 1:
						System.out.println("Enter Employee name");
						employee.setName(scanner.nextLine());
						EmployeeDB.updateEmployee(employee);
						break;
					case 2:
						System.out.println("Enter Salary of Employee");
						employee.setSalary(scanner.nextInt());
						scanner.nextLine();
						EmployeeDB.updateEmployee(employee);
						break;
					case 3:
						System.out.println("Enter DOJ as YYYY-MM-DD");
						employee.setDateOfJoin(scanner.next());
						scanner.nextLine();
						EmployeeDB.updateEmployee(employee);
						break;
					case 4:
						System.out.println("Enter Dept Id");
						int deptId = scanner.nextInt();
						scanner.nextLine();
						if(!EmployeeDB.isDepartmentPresent(deptId))
						{
							System.out.println("No dept with id "+ deptId);
							break;
						}
						employee.setDeptId(deptId);
						EmployeeDB.updateEmployee(employee);
						break;
						
				}
				
				
				break;
			}
			case 6: {
				//Number of employees in each department whose employee salary  greater than 30000
				EmployeeDB.countOfEmployeesByDept();
			}
			case 7: {
				EmployeeDB.close();
				status='N';
				break;
			}
			default:
				System.out.println("Invalid Option");
				System.out.println("Choose an option");
			}
			System.out.println();
		}while(status == 'Y' || status == 'y');
		scanner.close();
		System.out.println("Thank you");

	}


}
