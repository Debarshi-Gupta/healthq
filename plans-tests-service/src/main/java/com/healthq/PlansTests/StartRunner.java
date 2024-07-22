package com.healthq.PlansTests;

import com.healthq.PlansTests.service.PlanTestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartRunner implements ApplicationRunner {
	
	@Autowired
	private PlanTestServiceImpl planTestServiceImpl;
	
	@Override
	public void run(ApplicationArguments args) throws Exception
	{
		planTestServiceImpl.addData();
	}

}
