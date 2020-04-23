package com.rana.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class Servlet1 extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
		{
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			String name = req.getParameter("pname");
			int age = Integer.parseInt(req.getParameter("page"));
			String ms = req.getParameter("ms");
			if(ms.equals(null))
				ms = "single";
			
			if(ms.equals("married"))
			{
				pw.println("<form action = 'secondurl' method = 'POST'>");
				pw.println("Spouse Name : <input type ='text' name = 'st1'><br>");
				pw.println("Number of Children : <input type ='text' name = 'st2'><br>");
				pw.println("<input type ='submit' value = 'submit'>");
				pw.println("</form>");
					
			}
			else {
				pw.println("<form action = 'secondurl' method = 'POST'>");
				pw.println("When do you want to marry : <input type ='text' name = 'st1'><br>");
				pw.println("Why do you want to marry : <input type ='text' name = 'st2'><br>");
				pw.println("<input type ='submit' value = 'submit'>");
				pw.println("</form>");
			}
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		doGet(req, res);
	}

}
