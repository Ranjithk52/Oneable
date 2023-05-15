package com.ojas1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculate
 */
@WebServlet("./Calculate")
public class Calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
//		int i=Integer.parseInt(req.getParameter("num1"));
//		int j=Integer.parseInt(req.getParameter("num2"));
		String result=req.getParameter("Add");
		out.print(result);
	}
public void sum(){
System.out.println("hello");
	System.out.println("After changes");
	System.out.println("After changes11");
	System.out.println("After changes2");
	System.out.println("After changes21");
}

}
