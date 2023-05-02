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
 * Servlet implementation class EditUserServlet
 */
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		int eid=Integer.parseInt(req.getParameter("id"));
		Employee employe=new Employee();
		EmployeeDAOimpl empdao=new EmployeeDAOimpl();
		employe.setEmpid(Integer.parseInt(req.getParameter("empid")));
		employe.setName(req.getParameter("name"));
		
		employe.setEmail(req.getParameter("email"));
		employe.setEmpdomain(req.getParameter("domain"));
		String message=empdao.updateEmployee(eid, employe);
		out.println(message);
	}

}
