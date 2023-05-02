package com.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.dao.EmployeeDAOimpl;
import com.emp.model.Employee;
import com.emp.model.employ.EmployDAO;

/**
 * Servlet implementation class ViewAllServlet
 */
public class ViewAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		EmployDAO empdao=new EmployeeDAOimpl();
	       List<Employee> emp=empdao.viewAllEmployee();
	       
		
		res.setContentType("text/html");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>EmpId</th>");
		out.println("<th>Name</th>");
		out.println("<th>Email</th>");
		out.println("<th>Domain</th>");
		out.println("<th>Edit</th>");
		out.println("<th>Delete</th>");
		out.println("</tr>");
		for(Employee em:emp){
			out.println("<tr>");
			out.println("<td>"+em.getEmpid()+"</td>");
			out.println("<td>"+em.getName()+"</td>");
			out.println("<td>"+em.getEmail()+"</td>");
			out.println("<td>"+em.getEmpdomain()+"</td>");
			
			out.println("<td><a href='edit?id="+em.getEmpid()+"'>Edit</a></td>");
			out.println("<td><a href='delete?id="+em.getEmpid()+"'>Delete</a></td>");
			out.println("<td><a href='view?id="+em.getEmpid()+"'>View</a></td>");
			out.println("</tr>");
		
		}
		
		out.println("<table>");
		
	}

}
