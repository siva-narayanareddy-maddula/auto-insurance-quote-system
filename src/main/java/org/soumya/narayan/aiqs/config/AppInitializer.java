package org.soumya.narayan.aiqs.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
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
			
			FilterRegistration.Dynamic securityFilter = rootContext.addFilter(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME, DelegatingFilterProxy.class);
			securityFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), false, "/*");
			
			ServletRegistration.Dynamic dispatcher = rootContext.addServlet("dispatcherServlet", new DispatcherServlet(context));
			dispatcher.addMapping("/");
			dispatcher.setLoadOnStartup(1);
			
		}
	}
}
