package com.healthq.PlansTests.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import com.healthq.PlansTests.controller.AuthClient;
import com.healthq.PlansTests.repository.TestDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthq.PlansTests.model.AuthResponse;
import com.healthq.PlansTests.model.PlanDetails;
import com.healthq.PlansTests.model.PlanTestMapping;
import com.healthq.PlansTests.model.PlanTestWrapperObject;
import com.healthq.PlansTests.model.TestDetails;
import com.healthq.PlansTests.repository.PlanDetailsRepository;
import com.healthq.PlansTests.repository.PlanTestMappingRepository;

@Service
public class PlanTestServiceImpl implements PlanTestService {
	
	@Autowired
	private PlanDetailsRepository planDetailsRepository;
	
	@Autowired
	private TestDetailsRepository testDetailsRepository;
	
	@Autowired
	private PlanTestMappingRepository planTestMappingRepository;
	
	@Autowired
	private AuthClient authClient;
	
	private static Logger logger = LoggerFactory.getLogger(PlanTestServiceImpl.class);
	
	@Transactional
	public List<TestDetails> findAllTest()
	{
		logger.info("METHOD EXECUTION START");
		
		List<TestDetails> testList = testDetailsRepository.findAll();
		
		List<TestDetails> returnList = new ArrayList<>();
		
		for(TestDetails test:testList)
		{
			TestDetails testObj = new TestDetails(test.getId(),test.getTestName(),test.getDescription(), test.getUnit(), test.getRange(), test.getPrice());
			testObj.setPlanTestMapping(null);
			
			returnList.add(testObj);
		}
		
		logger.info("METHOD EXECUTION END - RETURNED TESTS SUCCESSFULLY");
		
		return returnList;
	}
	
	@Transactional
	public void addTest(TestDetails test)
	{
		logger.info("METHOD EXECUTION START");
		
		TestDetails testObj = new TestDetails(test.getTestName(), test.getDescription(), test.getUnit(), test.getRange(), test.getPrice());
		
		testDetailsRepository.save(testObj);
		
		logger.info("METHOD EXECUTION END - ADDED TEST SUCCESSFULLY");
	}
	
	@Transactional
	public void editTest(TestDetails test)
	{
		logger.info("METHOD EXECUTION START");
		
		TestDetails testObj = new TestDetails(test.getId(), test.getTestName(), test.getDescription(), test.getUnit(), test.getRange(), test.getPrice());
		
		testDetailsRepository.save(testObj);
		
		logger.info("METHOD EXECUTION END - EDITED TEST SUCCESSFULLY");
	}
	
	@Transactional
	public void removeTest(TestDetails test)
	{
		logger.info("METHOD EXECUTION START");
		
		testDetailsRepository.deleteById(test.getId());
		
		logger.info("METHOD EXECUTION END - REMOVED TEST SUCCESSFULLY");
	}
	
	@Transactional
	public List<PlanTestWrapperObject> findAllPlan()
	{
		logger.info("METHOD EXECUTION START");
		
		List<PlanDetails> planList = planDetailsRepository.findAll();
		
		List<PlanTestWrapperObject> planTestWrapperObjectList = new ArrayList<>();
		
		for(PlanDetails plan:planList)
		{
			PlanTestWrapperObject planTestWrapperObject = new PlanTestWrapperObject();
			
			PlanDetails planObj = new PlanDetails(plan.getId(),plan.getPlanName(),plan.getDescription());
			planObj.setPlanTestMapping(null);
			
			planTestWrapperObject.setPlan(planObj);
			
			Set<PlanTestMapping> planTestMappingList = plan.getPlanTestMapping();
			
			for(PlanTestMapping planTestMapping:planTestMappingList)
			{
				TestDetails testObj = new TestDetails(planTestMapping.getTest().getId(), planTestMapping.getTest().getTestName(), planTestMapping.getTest().getDescription(), planTestMapping.getTest().getUnit(), planTestMapping.getTest().getRange(), planTestMapping.getTest().getPrice());
				testObj.setPlanTestMapping(null);
				
				planTestWrapperObject.getTestList().add(testObj);
			}
			
			planTestWrapperObjectList.add(planTestWrapperObject);
		}
		
		logger.info("METHOD EXECUTION END - RETURNED PLANS SUCCESSFULLY");
		
		return planTestWrapperObjectList;
	}
	
	@Transactional
	public void addPlan(PlanDetails plan, List<TestDetails> testList)
	{
		logger.info("METHOD EXECUTION START");
		
		for(TestDetails test:testList)
		{
			PlanTestMapping planTestMapping = new PlanTestMapping();
			
			planTestMapping.setPlan(plan);
			planTestMapping.setTest(testDetailsRepository.findById(test.getId()));
			
			plan.getPlanTestMapping().add(planTestMapping);
		}
		
		planDetailsRepository.save(plan);
		
		logger.info("METHOD EXECUTION END - ADDED PLAN SUCCESSFULLY");
	}
	

	public void editPlan(PlanDetails plan, List<TestDetails> testList)
	{
		logger.info("METHOD EXECUTION START");
		
		planDetailsRepository.deleteById(plan.getId());
		
		for(TestDetails test:testList)
		{
			PlanTestMapping planTestMapping = new PlanTestMapping();
			
			planTestMapping.setPlan(plan);
			planTestMapping.setTest(testDetailsRepository.findById(test.getId()));
			
			plan.getPlanTestMapping().add(planTestMapping);
		}
		
		planDetailsRepository.save(plan);
		
		logger.info("METHOD EXECUTION END - EDITED PLAN SUCCESSFULLY");
	}
	
	@Transactional
	public void removePlan(PlanDetails plan, List<TestDetails> testList)
	{
		logger.info("METHOD EXECUTION START");
		
		planDetailsRepository.deleteById(plan.getId());
		
		logger.info("METHOD EXECUTION END - REMOVED PLAN SUCCESSFULLY");
	}
	
	public boolean isSessionValid(String token)
	{
		logger.info("METHOD EXECUTION START");
		
		try
		{
			@SuppressWarnings("unused")
            AuthResponse response = authClient.getValidity(token);
		}
		catch(Exception e)
		{
			logger.info("METHOD EXECUTION END - AUTHORIZATION FAILED");
			
			return false;
		}
		
		logger.info("METHOD EXECUTION END - AUTHORIZATION SUCCESSFUL");
		
		return true;
	}
	
	public void addData()
	{
		logger.info("METHOD EXECUTION START");
		
		TestDetails test1 = new TestDetails(1, "Optical Test", "Test For Eye.", "Optical Unit", "Optical Range", 1000);
		testDetailsRepository.save(test1);
		
		TestDetails test2 = new TestDetails(2, "Cardiac Test", "Test For Heart.", "Cardiac Unit", "Cardiac Range", 1500);
		testDetailsRepository.save(test2);
		
		TestDetails test3 = new TestDetails(3, "Auditory Test", "Test For Ear.", "Auditory Unit", "Auditory Range", 2000);
		testDetailsRepository.save(test3);
		
		PlanDetails plan1 = new PlanDetails(1, "Bronze Plan", "Most Basic Plan With Only Basic Benefits.");
		PlanDetails plan2 = new PlanDetails(2, "Silver Plan", "Budget Plan With All Necessary Benefits.");
		PlanDetails plan3 = new PlanDetails(3, "Gold Plan", "Premium Plan With All Benefits.");
		
		PlanTestMapping map1 = new PlanTestMapping(plan1, test1);
		PlanTestMapping map2 = new PlanTestMapping(plan2, test1);
		PlanTestMapping map3 = new PlanTestMapping(plan2, test2);
		PlanTestMapping map4 = new PlanTestMapping(plan3, test1);
		PlanTestMapping map5 = new PlanTestMapping(plan3, test2);
		PlanTestMapping map6 = new PlanTestMapping(plan3, test3);
		
		plan1.getPlanTestMapping().add(map1);
		plan2.getPlanTestMapping().add(map2);
		plan2.getPlanTestMapping().add(map3);
		plan3.getPlanTestMapping().add(map4);
		plan3.getPlanTestMapping().add(map5);
		plan3.getPlanTestMapping().add(map6);
		
		planDetailsRepository.save(plan1);
		planDetailsRepository.save(plan2);
		planDetailsRepository.save(plan3);
		
		logger.info("METHOD EXECUTION END - ADDED DATA SUCCESSFULLY");
	}
	
}
