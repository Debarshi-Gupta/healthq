package com.healthq.AdminLogin.service;

import java.util.ArrayList;

import com.healthq.AdminLogin.model.AdminDetails;
import com.healthq.AdminLogin.repository.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AdminDetailsServiceImpl implements AdminDetailsService {
	
	private static Logger logger = LoggerFactory.getLogger(AdminDetailsServiceImpl.class);
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username)
	{
		logger.info("METHOD EXECUTION START");
		
		try
		{
			AdminDetails adminDetails = adminRepository.findByUsername(username);
			
			if(adminDetails != null)
			{
				logger.info("METHOD EXECUTION END - USER FOUND");
				return new User(adminDetails.getUsername(), adminDetails.getPassword(), new ArrayList<>());
			}
			else
			{
				logger.info("METHOD EXECUTION END - USERNAME NOT FOUND");
				throw new UsernameNotFoundException("UsernameNotFoundException");
			}
		}
		
		catch (Exception e)
		{
			logger.info("EXCEPTION THROWN");
			throw new UsernameNotFoundException("UsernameNotFoundException");
		}
		
	}
	
	public void addData()
	{
		adminRepository.save(new AdminDetails(1, "admin1", passwordEncoder.encode("13579")));
		adminRepository.save(new AdminDetails(2, "admin2", passwordEncoder.encode("24680")));
		
	}

}
