package com.healthq.AdminLogin.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface AdminDetailsService extends UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(String username);
	
	public void addData();
	
	

}
