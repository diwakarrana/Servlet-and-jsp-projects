package com.rana.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

	@WebListener   //now no need of configuration in web.xml file here we are using annotations
public class SessionDurationListener implements HttpSessionListener {
	
		private long start, end;
		private ServletContext sc;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		start = System.currentTimeMillis();
		// write to log file
		sc = se.getSession().getServletContext();
		sc.log("**************************************session started at "+ new Date());
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
		end = System.currentTimeMillis();
		//  write to log file
		sc.log("session ended at "+ new Date());
		sc.log("****************************************************session duration"+ (end-start)+ "  ms");
	}

}
