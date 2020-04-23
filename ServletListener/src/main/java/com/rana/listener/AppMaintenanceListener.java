package com.rana.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppMaintenanceListener implements ServletContextListener {
	
	private ServletContext sc;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		//write to log file....
		sc = sce.getServletContext();
		sc.log("web application is deployed/reloaded at"+ new Date());
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		//write to log fil.....
		sc.log("web application is undeployed at " + new Date());
		
	}

}
