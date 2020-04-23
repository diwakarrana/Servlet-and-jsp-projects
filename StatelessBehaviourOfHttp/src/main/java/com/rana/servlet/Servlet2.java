package com.rana.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class Servlet2 extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
		{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		pw.println("<br>first form data");
		pw.println("<br> name is" + req.getParameter("pname"));
		pw.println("<br> Age is " + req.getParameter("page"));
		pw.println("<br> Marital Status " + req.getParameter("ms"));
		
		
		pw.println("<br>Second form data");
		pw.println(req.getParameter("st1"));
		pw.println(req.getParameter("st2"));
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		doGet(req, res);
	}

}
