package com.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.dao.EmployeeDAOimpl;
import com.emp.model.Employee;
import com.emp.model.employ.EmployDAO;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		EmployDAO empdao=new EmployeeDAOimpl();
		Employee emp=new Employee();
		res.setContentType("text/html");
		int empid=Integer.parseInt(req.getParameter("id"));
		emp=empdao.viewEmployee(empid);
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>EmpId</th>");
		out.println("<th>Name</th>");
		out.println("<th>Email</th>");
		out.println("<th>Domain</th>");
		out.println("</tr>");
		
	
		out.println("<tr>");
		out.println("<td>"+emp.getEmpid()+"</td>");
		out.println("<td>"+emp.getName()+"</td>");
		out.println("<td>"+emp.getEmail()+"</td>");
		out.println("<td>"+emp.getEmpdomain()+"</td>");
		out.println("</tr>");
		
		
		
	}

}
