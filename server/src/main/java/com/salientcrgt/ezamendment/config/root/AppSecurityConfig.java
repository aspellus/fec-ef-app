package com.salientcrgt.ezamendment.config.root;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
*
* The Spring Security configuration for the application 
*
* The CSRF token is put on the reply as a header via a filter, as there is no server-side rendering on this app.
*
*/

@Configuration
//@EnableWebSecurity
public class AppSecurityConfig  extends WebSecurityConfigurerAdapter {
	@Override
	public void configure (WebSecurity http) throws Exception {
	    //http.csrf().disable();
		// Allowing all OPTIONS requests 
	    http.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	    
	}
}
