package org.soumya.narayan.aiqs.config.web.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityContext extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource aiqsDataSource;
	
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth
			.jdbcAuthentication()
			.dataSource(aiqsDataSource)
			// select username,password,enabled from users where username = ? -- this is the query which spring uses
		    .usersByUsernameQuery("SELECT USER_ID AS USERNAME, PASSWORD, ENABLED FROM LOGIN_CREDENTIALS WHERE USER_ID = ?")
			//select username,authority from authorities where username = ? -- this is the query which spring uses
		    .authoritiesByUsernameQuery("SELECT USER_ID AS USERNAME, AUTHORITY FROM AUTHORITIES WHERE USER_ID = ?");
	}
	
}
