package org.siva.narayan.aiqs.config.web.security;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityContext extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource aiqsDataSource;

	@Value(value = "${super_users}")
	private String superUsers;

	@PostConstruct
	public void postConstruct() {
		System.out.println("superUsers === " + superUsers);
	}

	@Autowired
	public void configureGlobalUsers(AuthenticationManagerBuilder auth) throws Exception {
		for (final String userPrincipal : superUsers.split("&")) {
			final String userDetails[] = userPrincipal.split(":");
			if(userDetails.length > 0) {
				auth.inMemoryAuthentication()
						.withUser(userDetails[0])
							.password(userDetails[1])
								.authorities("SUPER_ADMIN");
			} else {
				System.err.println("Super User Configuration Error :: "+ Arrays.toString(userDetails));
			}
		}
	}
}

