package com.healthq.AdminLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdminLoginApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AdminLoginApplication.class, args);
		
	}
	

}
