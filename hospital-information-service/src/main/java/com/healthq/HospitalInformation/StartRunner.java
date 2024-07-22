package com.healthq.HospitalInformation;

import com.healthq.HospitalInformation.service.HospitalInformationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartRunner implements ApplicationRunner {
	
	@Autowired
	private HospitalInformationServiceImpl hospitalInformationService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception
	{
		hospitalInformationService.addData();
	}
	
	

}
