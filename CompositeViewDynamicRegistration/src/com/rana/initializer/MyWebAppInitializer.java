package com.rana.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.rana.servlet.HeaderServlet;

public class MyWebAppInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
	
		HeaderServlet servlet = new HeaderServlet();
		ServletRegistration.Dynamic dynamicRegistration = sc.addServlet("hederServlet", servlet);
		
		//adding url to servlet component
		dynamicRegistration.addMapping("/headerurl");
		
		//load on startup 
		dynamicRegistration.setLoadOnStartup(2); 
	}

}
