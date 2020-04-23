package com.rana.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/thirdservlet")
public class ThirdServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	 PrintWriter pw = response.getWriter();
	 response.setContentType("text/html");
	 
	 //reading data from form........
	 
	 String city = request.getParameter("city");
	 int salary = Integer.parseInt(request.getParameter("salary"));
	 //pw.println(city +"  "+salary);
	 
	 // create session for browser window ....
	 HttpSession session = request.getSession(false);
	 // keep the data to session attribute.......
	 
	 
	 //read from1 and form 2 data from session object
	 String name = (String)session.getAttribute("name");
	 String address = (String)session.getAttribute("address");
	 int age = (Integer)session.getAttribute("age");
	 String skill = (String)session.getAttribute("skill");
	 int exp = (Integer)session.getAttribute("exp");
	 //pw.println(name+" "+address+" "+skill+" "+age+" "+exp+" "+salary+" "+city);
	 
	 pw.println("<a>home1</a>");
	 pw.println(name+" "+age+" "+address+" "+exp+" "+skill+" "+salary+" "+city);
		// store the data into database.............................
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			PreparedStatement ps = con.prepareStatement("INSERT INTO SESSIONINFO VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setInt(3, age);
			ps.setString(4, skill);
			ps.setInt(5, exp);
			ps.setString(6, city);
			ps.setInt(7, salary);
			
			int i = ps.executeUpdate();
			if (i>0)
			{
				pw.println("successful");
			}
			else {
				pw.println("not successful");
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			pw.println("try again with modification");
		}
		
		pw.println("<a>home2</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
