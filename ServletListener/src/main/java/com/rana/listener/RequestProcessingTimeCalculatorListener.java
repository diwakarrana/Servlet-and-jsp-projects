package com.rana.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestProcessingTimeCalculatorListener implements ServletRequestListener {
	
	private long start, end;
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		start = System.currentTimeMillis();
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		end = System.currentTimeMillis();
		//write request processing time to log file
		
		ServletContext sc =sre.getServletContext();
		sc.log("see rana is doing something");
		sc.log(((HttpServletRequest)sre.getServletRequest()).getRequestURL()+ "has taken" + (end - start)+" ms");
		
	}

}
