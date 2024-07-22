package com.healthq.Members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.healthq.Members.service.MembersServiceImpl;

@Component
public class StartRunner implements ApplicationRunner {
	
	@Autowired
	private MembersServiceImpl membersServiceImpl;
	
	@Override
	public void run(ApplicationArguments args) throws Exception
	{
		membersServiceImpl.addData();
	}
	
	

}
