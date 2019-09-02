package com.learning.app.ws.security;

import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.learning.app.ws.service.UserService;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

	private final UserService detailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public WebSecurity(UserService detailsService,BCryptPasswordEncoder bCryptPasswordEncoder) {
			this.detailsService = detailsService;
			this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		 auth.userDetailsService(detailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf()
		 .disable() .authorizeRequests() .antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL)
		  .permitAll() .anyRequest()
		  .authenticated().and().addFilter(getAuthenticationFilter())
		  .addFilter(new AutherizationFIlter(authenticationManager()))
		  .sessionManagement()
		  .sessionCreationPolicy(SessionCreationPolicy.STATELESS); 
		
//		  .permitAll() .anyRequest().authenticated().and().addFilter(new AuthenticationFilter(authenticationManager())); 
	}
	
	public AuthenticationFilter getAuthenticationFilter() throws Exception{
		final AuthenticationFilter filter  = new AuthenticationFilter(authenticationManager());
		filter.setFilterProcessesUrl("/users/login");
		return filter;
	}
	 
}
