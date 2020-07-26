package com.techfeense.vitualstoreproduct.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	private final Environment environment;
	
	@Autowired
	public WebSecurity(Environment environment) {
		this.environment = environment;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/products").permitAll()
		.antMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
		.and().authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.addFilter(new AuthorizationFilter(authenticationManager(), environment));
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
