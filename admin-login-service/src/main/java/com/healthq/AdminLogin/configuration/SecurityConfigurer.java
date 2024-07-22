package com.healthq.AdminLogin.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.healthq.AdminLogin.service.AdminDetailsServiceImpl;

@EnableWebSecurity
@Configuration
@EnableWebMvc
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	private static Logger logger = LoggerFactory.getLogger(SecurityConfigurer.class);
	
	@Autowired
	private AdminDetailsServiceImpl adminDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		logger.info("METHOD EXECUTION START");
		
		auth.userDetailsService(adminDetailsService);
		
		logger.info("METHOD EXECUTION END");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		logger.info("METHOD EXECUTION START");
		
		http.csrf().disable().authorizeRequests()
			.antMatchers("/**").permitAll()
			.anyRequest().authenticated().and()
			.exceptionHandling().and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		logger.info("METHOD EXECUTION END");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception
	{
		logger.info("METHOD EXECUTION START");
		
		web.ignoring().antMatchers("/authapp/login", "/h2-console/**",
				"/v2/api-docs", "/configuration/ui", 
				"/configuration/security", "/webjars/**", "/swagger-ui");
		
		logger.info("METHOD EXECUTION END");
	}
	
	 @Bean
	 public DaoAuthenticationProvider authProvider() 
	 {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(adminDetailsService);
	    authProvider.setPasswordEncoder(passwordEncoder());
	    return authProvider;
	 }

	 @Bean
	 public PasswordEncoder passwordEncoder() 
	 {
	    return new BCryptPasswordEncoder();
	 }
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		logger.info("METHOD EXECUTION START");
		logger.info("METHOD EXECUTION END");
		
		return super.authenticationManagerBean();
	}
	

}
