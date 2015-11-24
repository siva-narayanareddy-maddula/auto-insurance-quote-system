package org.soumya.narayan.aiqs.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

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
		
		try(AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext()) {
			context.setDisplayName("auto-insurance-quote-system");

			context.register(AppContext.class);
			rootContext.addListener(new ContextLoaderListener(context));
			
			Dynamic dispatcher = rootContext.addServlet("dispatcherServlet", new DispatcherServlet(context));
			dispatcher.addMapping("/");
			dispatcher.setLoadOnStartup(1);
			
		}
	}
}
