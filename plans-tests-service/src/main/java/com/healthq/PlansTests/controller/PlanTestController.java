package com.healthq.PlansTests.controller;

import javax.validation.constraints.NotNull;

import com.healthq.PlansTests.model.TestDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.healthq.PlansTests.model.PlanTestWrapperObject;
import com.healthq.PlansTests.service.PlanTestServiceImpl;

@RestController
@CrossOrigin
public class PlanTestController {
	
	@Autowired
	private PlanTestServiceImpl planTestServiceImpl;
	
	private static Logger logger = LoggerFactory.getLogger(PlanTestController.class);
	
	@GetMapping("/getAllTest")
	public ResponseEntity<?> getAllTest(@RequestHeader("Authorization") @NotNull String token)
	{
		logger.info("METHOD EXECUTION START");
		
		if(planTestServiceImpl.isSessionValid(token))
		{
			logger.info("METHOD EXECUTION END - RETRIEVED TESTS SUCCESSFULLY");
			
			return new ResponseEntity<>(planTestServiceImpl.findAllTest(), HttpStatus.OK);
		}
		
		logger.info("METHOD EXECUTION END - AUTHORIZATION ERROR");
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("/createTest")
	public ResponseEntity<?> createTest(@RequestHeader("Authorization") @NotNull String token, @RequestBody @NotNull TestDetails test)
	{
		logger.info("METHOD EXECUTION START");
		
		if(planTestServiceImpl.isSessionValid(token))
		{
			planTestServiceImpl.addTest(test);
			
			logger.info("METHOD EXECUTION END - CREATED TEST SUCCESSFULLY");
			
			return new ResponseEntity<>("CREATED TEST SUCCESSFULLY", HttpStatus.OK);
		}
		
		logger.info("METHOD EXECUTION END - AUTHORIZATION ERROR");
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("/updateTest")
	public ResponseEntity<?> updateTest(@RequestHeader("Authorization") @NotNull String token, @RequestBody @NotNull TestDetails test)
	{
		logger.info("METHOD EXECUTION START");
		
		if(planTestServiceImpl.isSessionValid(token))
		{
			planTestServiceImpl.editTest(test);
			
			logger.info("METHOD EXECUTION END - UPDATED TEST SUCCESSFULLY");
			
			return new ResponseEntity<>("UPDATED TEST SUCCESSFULLY", HttpStatus.OK);
		}
		
		logger.info("METHOD EXECUTION END - AUTHORIZATION ERROR");
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("/deleteTest")
	public ResponseEntity<?> deleteTest(@RequestHeader("Authorization") @NotNull String token, @RequestBody @NotNull TestDetails test)
	{
		logger.info("METHOD EXECUTION START");
		
		if(planTestServiceImpl.isSessionValid(token))
		{
			planTestServiceImpl.removeTest(test);
			
			logger.info("METHOD EXECUTION END - DELETED TEST SUCCESSFULLY");
			
			return new ResponseEntity<>("DELETED TEST SUCCESSFULLY", HttpStatus.OK);
		}
		
		logger.info("METHOD EXECUTION END - AUTHORIZATION ERROR");
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	@GetMapping("/getAllPlan")
	public ResponseEntity<?> getAllPlan(@RequestHeader("Authorization") @NotNull String token)
	{
		logger.info("METHOD EXECUTION START");
		
		if(planTestServiceImpl.isSessionValid(token))
		{
			logger.info("METHOD EXECUTION END - RETRIEVED PLANS SUCCESSFULLY");
			
			return new ResponseEntity<>(planTestServiceImpl.findAllPlan(), HttpStatus.OK);
		}
		
		logger.info("METHOD EXECUTION END - AUTHORIZATION ERROR");
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("/createPlan")
	public ResponseEntity<?> createPlan(@RequestHeader("Authorization") @NotNull String token, @RequestBody @NotNull PlanTestWrapperObject planTestWrapperObject)
	{
		logger.info("METHOD EXECUTION START");
		
		if(planTestServiceImpl.isSessionValid(token))
		{
			planTestServiceImpl.addPlan(planTestWrapperObject.getPlan(), planTestWrapperObject.getTestList());
			
			logger.info("METHOD EXECUTION END - CREATED PLAN SUCCESSFULLY");
			
			return new ResponseEntity<>("CREATED PLAN SUCCESSFULLY", HttpStatus.OK);
		}
		
		logger.info("METHOD EXECUTION END - AUTHORIZATION ERROR");
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("/updatePlan")
	public ResponseEntity<?> updatePlan(@RequestHeader("Authorization") @NotNull String token, @RequestBody @NotNull PlanTestWrapperObject planTestWrapperObject)
	{
		logger.info("METHOD EXECUTION START");
		
		if(planTestServiceImpl.isSessionValid(token))
		{
			planTestServiceImpl.editPlan(planTestWrapperObject.getPlan(), planTestWrapperObject.getTestList());
			
			logger.info("METHOD EXECUTION END - UPDATED PLAN SUCCESSFULLY");
			
			return new ResponseEntity<>("UPDATED PLAN SUCCESSFULLY", HttpStatus.OK);
		}
		
		logger.info("METHOD EXECUTION END - AUTHORIZATION ERROR");
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("/deletePlan")
	public ResponseEntity<?> deletePlan(@RequestHeader("Authorization") @NotNull String token, @RequestBody @NotNull PlanTestWrapperObject planTestWrapperObject)
	{
		logger.info("METHOD EXECUTION START");
		
		if(planTestServiceImpl.isSessionValid(token))
		{
			planTestServiceImpl.removePlan(planTestWrapperObject.getPlan(), planTestWrapperObject.getTestList());
			
			logger.info("METHOD EXECUTION END - DELETED PLAN SUCCESSFULLY");
			
			return new ResponseEntity<>("DELETED PLAN SUCCESSFULLY", HttpStatus.OK);
		}
		
		logger.info("METHOD EXECUTION END - AUTHORIZATION ERROR");
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	@GetMapping("/searchAllPlan")
	public ResponseEntity<?> searchAllPlan()
	{
		logger.info("METHOD EXECUTION START");
		
		logger.info("METHOD EXECUTION END - RETRIEVED PLAN DETAILS SUCCESSFULLY");
		
		return new ResponseEntity<>(planTestServiceImpl.findAllPlan(), HttpStatus.OK);
	}

}
