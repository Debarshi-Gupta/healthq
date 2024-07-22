package com.healthq.PlansTests.service;

import java.util.List;

import com.healthq.PlansTests.model.TestDetails;
import org.springframework.stereotype.Service;

@Service
public interface PlanTestService {
	
	public List<TestDetails> findAllTest();
	
	public void addTest(TestDetails test);
	
	public void editTest(TestDetails test);
	
	public void removeTest(TestDetails test);
	
	public boolean isSessionValid(String token);
	
	public void addData();

}
