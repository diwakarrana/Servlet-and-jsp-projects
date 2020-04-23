package com.rana.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//set response content type 
		res.setContentType("text/html");
		//get printer writer object
		PrintWriter pw = res.getWriter();
		//write response
		Date d = new Date();
		pw.println("<b><i><centr>Date and time is"+d+"</centr></i></b>");
		//close stream
		pw.close();
	}// service 
}//classes
