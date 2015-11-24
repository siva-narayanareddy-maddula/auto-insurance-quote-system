package org.soumya.narayan.aiqs.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

/**
 * App Initializer class
 * 
 * @author si255323
 *
 */
public class AppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext rootContext) throws ServletException {
		
		System.out.println("Initializing the App");
		//TODO :: need to implement the servlet configuration
	}
}
