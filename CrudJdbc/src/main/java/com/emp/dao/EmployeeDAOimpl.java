package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.dp.DBUtility;
import com.emp.model.Employee;
import com.emp.model.employ.EmployDAO;

public class EmployeeDAOimpl implements EmployDAO{
	public static Connection con=DBUtility.getCOnnection();
	PreparedStatement ps=null;
	List<Employee> employees=null;
	ResultSet rs=null;
	Employee employee=null;
	String message=null;
	int n=0;
	
	

	public String createEmployee(Employee employee) {
		try {
			ps=con.prepareStatement("Insert into employee values(?,?,?,?)");
			ps.setInt(1, employee.getEmpid());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getEmail());
			ps.setString(4, employee.getEmpdomain());
			int n=ps.executeUpdate();
			if(n!=0){
				message="Successfully inserted";
			}
			else{
				message="Please try again....";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public Employee viewEmployee(int empid) {
		try {
			ps=con.prepareStatement("Select * from employee where empid=?");
			ps.setInt(1, empid);
			
			
			rs=ps.executeQuery();
			if(rs.next()){
				employee= new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employee;
	}

	public List<Employee> viewAllEmployee() {
		employees=new ArrayList<Employee>();
		try {
			ps=con.prepareStatement("Select * from employee");
			rs=ps.executeQuery();
			while(rs.next()){
				employee= new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				employees.add(employee);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}

	public String updateEmployee(int empid, Employee updateEmployee) {
		try {
			ps=con.prepareStatement("update employee set name=?,email=?,empdomain=? where empid=?");
			ps.setString(1, updateEmployee.getName());
			ps.setString(2, updateEmployee.getEmail());
			ps.setString(3, updateEmployee.getEmpdomain());
			ps.setInt(4, updateEmployee.getEmpid());
			n=ps.executeUpdate();
			if(n!=0){
				message="Successfully Updated Data...";
				
			}else{
				message="Please Try Again......";
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
	}

	public String deleteEmployee(int empid) {
		try {
			ps=con.prepareStatement("Delete from Employee where empid=?");
			ps.setInt(1, empid);
			n=ps.executeUpdate();
			 if(n!=0){
				 message="Successfully Record Deleted.....";
			 }
			 else{
				 message="Try again once.....";
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
	}

}
