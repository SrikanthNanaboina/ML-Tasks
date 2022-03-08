package com.bhavna.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmployeePage {
	private int currentPage;
    private long totalEmployees;
    private int totalPages;
    private List<Employee> employees;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public long getTotalEmployees() {
		return totalEmployees;
	}
	public void setTotalEmployees(long totalEmployees) {
		this.totalEmployees = totalEmployees;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
