package com.healthq.AdminLogin.controller;

import javax.validation.constraints.NotNull;

import com.healthq.AdminLogin.model.AdminDetails;
import com.healthq.AdminLogin.model.AuthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.healthq.AdminLogin.service.AdminDetailsServiceImpl;
import com.healthq.AdminLogin.service.JWTUtil;

@RestController
@CrossOrigin
public class LoginController {
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private AdminDetailsServiceImpl adminDetailsService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @NotNull AdminDetails adminLoginCredentials)
	{
		logger.info("METHOD EXECUTION START");
		
		final UserDetails userDetails = adminDetailsService.loadUserByUsername(adminLoginCredentials.getUsername());
		
		String generateToken = "";
		
		if(passwordEncoder.matches(adminLoginCredentials.getPassword(), userDetails.getPassword()))
		{
			generateToken = jwtUtil.generateToken(userDetails);
			logger.info("GENERATED TOKEN : {}", generateToken);
			logger.info("METHOD EXECUTION END - CORRECT CREDENTIALS");
			
			return new ResponseEntity<>(generateToken, HttpStatus.OK);
		}
		else
		{
			logger.info("METHOD EXECUTION END - WRONG CREDENTIALS");
			return new ResponseEntity<>("NOT ACCESSIBLE", HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping("/validate")
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String token)
	{
		logger.info("METHOD EXECUTION START");
		
		AuthResponse response = new AuthResponse();
		
		if(token == null)
		{
			response.setValid(false);
			
			logger.info("METHOD EXECUTION END - NULL TOKEN");
			
			return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
		}
		
		else
		{
			String token1 = token.substring(7);
			if(jwtUtil.validateToken(token1))
			{
				response.setUsername(jwtUtil.extractUsername(token1));
				response.setValid(true);
			}
			else
			{
				response.setValid(false);
				logger.info("METHOD EXECUTION END - TOKEN EXPIRED");
				
				return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
			}
		}
		
		logger.info("METHOD EXECUTION END - TOKEN ACCEPTED");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
