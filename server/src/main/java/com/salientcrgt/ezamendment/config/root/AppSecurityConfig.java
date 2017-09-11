package com.salientcrgt.ezamendment.config.root;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
*
* The Spring Security configuration for the application 
*
* The CSRF token is put on the reply as a header via a filter, as there is no server-side rendering on this app.
*
*/

@Configuration
@EnableWebSecurity
public class AppSecurityConfig  extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure (HttpSecurity http) throws Exception {
	    http.csrf().disable();
	}
}
