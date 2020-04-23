package com.rana.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		 Cookie[] cks = req.getCookies();
		 
		 String name = cks[0].getValue();
		 String age = cks[1].getValue();
		 
		 String f2t1 = req.getParameter("f2t1");
		 String f2t2 = req.getParameter("f2t2");
		 
		 pw.println(name);
		 pw.println(age);
		 pw.println(f2t1);
		 pw.println(f2t2);
}

public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
{
		doGet(req, res);
}
}
