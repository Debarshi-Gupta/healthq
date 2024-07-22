package com.healthq.AdminLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.healthq.AdminLogin.service.AdminDetailsServiceImpl;


@Component
public class StartRunner implements ApplicationRunner {

    
	@Autowired
	private AdminDetailsServiceImpl adminDetailsService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
    	
        adminDetailsService.addData();
    }
}

