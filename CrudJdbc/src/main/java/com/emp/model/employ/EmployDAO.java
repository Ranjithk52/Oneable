package com.emp.model.employ;

import java.util.List;

import com.emp.model.Employee;

public interface EmployDAO {
	public String createEmployee(Employee employee);
	public Employee viewEmployee(int empid);
	public List<Employee> viewAllEmployee();
	public String updateEmployee(int empid,Employee updateEmployee);
	public String deleteEmployee(int empid);
	
	
}
