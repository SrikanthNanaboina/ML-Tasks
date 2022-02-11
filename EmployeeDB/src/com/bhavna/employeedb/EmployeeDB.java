package com.bhavna.employeedb;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EmployeeDB {
	
	static Connection connection;

	static void connectToDB() {
		try {
			 
	        String dbURL = "jdbc:sqlserver://localhost\\BHAVNAWK738;databaseName=ML_DB;portNumber=1434";
	        String user = "sa";
	        String pass = "Bhavna@123";
	        connection = DriverManager.getConnection(dbURL, user, pass);
	        if (connection != null) {
	            System.out.println("Connection Established");
	        }
	
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	static void close() {
		try {
			if(connection!=null) {
				connection.close();
				System.out.println("Connection closed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static void addEmployee(Employee employee) {
		    String query = "INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)";
		    PreparedStatement ps;
			try {
				ps = connection.prepareStatement(query);
			    ps.setLong(1, employee.getId());
			    ps.setString(2, employee.getName());
			    ps.setDouble(3, employee.getSalary());
			    ps.setString(4, employee.getDateOfJoin());
			    ps.setInt(5, employee.getDeptId());
			    ps.executeUpdate();
			    System.out.println("Emp added");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	static void updateEmployee(Employee employee) {
	    //String query = "INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)";
	    String query = "UPDATE EMPLOYEE SET E_NAME = ?,  SALARY = ?, DATE_OF_JOINING = ?,   DEPT_ID = ? WHERE E_ID = ?;";
	    PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
		    ps.setLong(5, employee.getId());
		    ps.setString(1, employee.getName());
		    ps.setDouble(2, employee.getSalary());
		    ps.setString(3, employee.getDateOfJoin());
		    ps.setInt(4, employee.getDeptId());
		    ps.executeUpdate();
		    System.out.println("Emp Updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
}

	static void addDepartment(int deptID, String name) {
	    String query = "INSERT INTO Department VALUES(? , ?)";
	    PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
		    ps.setInt(1, deptID);
		    ps.setString(2, name);
		    ps.executeUpdate();
		    System.out.println("Dept added");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void listEmployees() {
	    String query = "SELECT * FROM EMPLOYEE INNER JOIN DEPARTMENT ON EMPLOYEE.DEPT_ID = DEPARTMENT.DEPT_ID";
	    Statement s ; 
		try {
			s = connection.createStatement();
		    ResultSet rs = s.executeQuery(query);
		    while(rs.next()) {
		    	System.out.println("[ ID: " + rs.getLong("E_ID") 
		    						+ " Name: " + rs.getString("E_NAME") 
		    						+ " SALARY: " + rs.getDouble("SALARY") 
		    						+ " DOJ: " + rs.getString("DATE_OF_JOINING") 
		    						+ " Department Id: " + rs.getInt("DEPT_ID")
		    						+ " Department Name: " + rs.getString("DEPT_NAME")
		    						+ " ]");
		    	
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static void listDepartments() {
	    String query = "SELECT * FROM DEPARTMENT";
	    Statement s ; 
		try {
			s = connection.createStatement();
		    ResultSet rs = s.executeQuery(query);
		    while(rs.next()) {
		    	System.out.println("ID: " + rs.getInt("DEPT_ID") + " Department Name: " + rs.getString("DEPT_NAME"));
		    	
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Employee getEmployee(long empID) {
		String query = "SELECT * FROM EMPLOYEE WHERE E_ID = ?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setLong(1, empID);
		    ResultSet rs  = ps.executeQuery();
		    if(rs.next()) {
		    	return new Employee(empID, rs.getString("E_NAME"), rs.getDouble("SALARY"),rs.getString("DATE_OF_JOINING") , rs.getInt("DEPT_ID"));	
		    }
		    else {
		    	System.out.println("No Employee found");
		    	return null;
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//write a query for find the number of employees in each department  
	//whose employee sal  greater than 30000.(fetch coulms dept name,count of emplyee)
	public static void countOfEmployeesByDept() {
		String query = "SELECT DEPT_NAME, COUNT(*) AS NO_OF_EMP FROM EMPLOYEE INNER JOIN DEPARTMENT ON EMPLOYEE.DEPT_ID = DEPARTMENT.DEPT_ID WHERE SALARY >= 30000 GROUP BY DEPT_NAME ";
		 Statement s ; 
			try {
				s = connection.createStatement();
			    ResultSet rs = s.executeQuery(query);
			    if(!rs.next()) System.out.println("No employees with more than 30000 salary");
			    
			    do {
			    	System.out.println(" Department Name: " + rs.getString("DEPT_NAME")+"\n No of employees with more than 30000 : "+ rs.getString("NO_OF_EMP"));
			    	System.out.println();
			    	
			    } while(rs.next());
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static boolean isEmployeePresent(long empID) {
		String query = "SELECT E_ID FROM EMPLOYEE WHERE E_ID = ?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setLong(1, empID);
		    ResultSet resultSet  = ps.executeQuery();
		    return resultSet.next() ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	static boolean isDepartmentPresent(int deptID) {
		String query = "SELECT DEPT_ID FROM DEPARTMENT WHERE DEPT_ID = ?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, deptID);
		    ResultSet resultSet  = ps.executeQuery();
		    return resultSet.next() ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
