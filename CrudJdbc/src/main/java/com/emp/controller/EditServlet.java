package com.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.dao.EmployeeDAOimpl;
import com.emp.model.Employee;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi' crossorigin='anonymous'>");

		int eid=Integer.parseInt(req.getParameter("id"));
		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employ","root","root");
//		PreparedStatement ps=con.prepareStatement("Select * from employee where empid=?");
//		
//		ps.setInt(1, eid);
//		ResultSet rs=ps.executeQuery();
//		rs.next();
		EmployeeDAOimpl empdao=new EmployeeDAOimpl();
		Employee emp=new Employee();
		emp=empdao.viewEmployee(eid);
		
		
		
		out.println("<div style='margin:auto;width:500px;margin-top:100px;'>");
		out.println("<form action='edituser?id="+eid+"' method='post'>");	
		out.println("<table  class='table table-hover table-striped>");
		out.println("<tr>");
		out.println("<td>Empid</td>");
		out.println("<td><input type='text' name='empid' value='"+emp.getEmpid()+"'</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Empid</td>");
		out.println("<td><input type='text' name='empid' value='"+emp.getEmpid()+"'</td>");
		out.println("</tr>");
		
			out.println("<tr>");
			out.println("<td>Name</td>");
			out.println("<td><input type='text' name='name' value='"+emp.getName()+"'</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Email</td>");
			out.println("<td><input type='email' name='email' value='"+emp.getEmail()+"'</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Domain</td>");
			out.println("<td><input type='text' name='domain' value='"+emp.getEmpdomain()+"'</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td><button type='submit' class='btn btn-outline-success'>Edit</button></td>");
			out.println("<td><button type='reset' class='btn btn-outline-danger'>Cancel</button></td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</form>");
		
//
//		} catch (SQLException e) {
//			out.println("<h2 class='bg-danger text-light text-center'>"+e.getMessage()+"</h2>");
//			
//			e.printStackTrace();
//		}catch (Exception e) { 
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		out.println("<a href='CreateEmployee.html'><button  class='btn btn-outline-success'>Home</button>");
		out.println("</div>");
		out.close();
	}

}
