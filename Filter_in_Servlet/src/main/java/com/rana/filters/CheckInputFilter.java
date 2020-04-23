package com.rana.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/sumurl")
public class CheckInputFilter extends HttpFilter implements Filter {
       
	/*
	 * @Override public void destroy() {
	 * 
	 * }
	 */
   @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	   PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		int first = Integer.parseInt(request.getParameter("first"));
		int second = Integer.parseInt(request.getParameter("second"));
		
		if(first < 0 || second < 0) {
			pw.println(" inter number must be positive ");
		}
		else {
			chain.doFilter(request, response);
		}
		
	}
   
	/*
	 * @Override public void init(FilterConfig fConfig) throws ServletException {
	 * 
	 * }
	 */
}
