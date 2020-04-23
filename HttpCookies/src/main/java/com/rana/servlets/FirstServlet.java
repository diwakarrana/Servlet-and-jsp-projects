package com.rana.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String ms = req.getParameter("ms");
		
		if(ms == null)
			ms = "single";
		
		Cookie ck1 = new Cookie("name", name);
		Cookie ck2 = new Cookie("age", age);
		
		res.addCookie(ck1);
		res.addCookie(ck2);
		//pw.println(name + age +ms);
		
		
		//...............................dynamic form page..........................................
		
		if (ms.equals("married"))
		{
			pw.println("<form action=\"SecondServlet\" method=\"POST\">\r\n" + 
					"		Spouse name<input type=\"text\" name=\"f2t1\"><br>\r\n" + 
					"		no of children <input type=\"text\" name=\"f2t2\"><br>\r\n" + 
					"		<input type=\"submit\" value=\"submit\">\r\n" + 
					"	</form>");
			
		}
		else
			if(ms.equals("single"))
			{
				pw.println("<form action=\"SecondServlet\" method=\"POST\">\r\n" + 
						"		why you want to marry<input type=\"text\" name=\"f2t1\"><br>\r\n" + 
						"		when you want to marry <input type=\"text\" name=\"f2t2\"><br>\r\n" + 
						"		<input type=\"submit\" value=\"submit\">\r\n" + 
						"	</form>");
			}
	}
		
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		doGet(req, res);
	}

}
