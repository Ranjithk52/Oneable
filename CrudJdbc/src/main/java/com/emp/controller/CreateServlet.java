package com.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.dao.EmployeeDAOimpl;
import com.emp.model.Employee;

/**
 * Servlet implementation class CreateServlet
 */
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		Employee emp=new Employee();
		EmployeeDAOimpl empdao=new EmployeeDAOimpl();
		emp.setEmpid(Integer.parseInt(req.getParameter("eid")));
		emp.setName(req.getParameter("ename"));
		emp.setEmail(req.getParameter("email"));
		emp.setEmpdomain(req.getParameter("empdomain"));
		String msg=empdao.createEmployee(emp);
		out.println("<h1 style=color:blue>"+msg+"</h1>");
		out.println("<a href='./viewall'>Show Employees</a>");
		
		
	}

}
