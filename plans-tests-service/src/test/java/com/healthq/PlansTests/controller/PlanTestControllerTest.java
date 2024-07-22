package com.healthq.PlansTests.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import com.healthq.PlansTests.model.PlanTestWrapperObject;
import com.healthq.PlansTests.model.TestDetails;
import com.healthq.PlansTests.service.PlanTestServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@AutoConfigureMockMvc
public class PlanTestControllerTest {
	
	@Mock
	private PlanTestServiceImpl planTestServiceImpl;
	
	@InjectMocks
	private PlanTestController planTestController;
	
	@Test
	public void contextLoads()
	{
		assertNotNull(planTestController);
	}
	
	@Test
	public void getAllTestTestSuccess() throws Exception
	{
		when(planTestServiceImpl.isSessionValid(anyString())).thenReturn(true);
		
		ResponseEntity<?> response = planTestController.getAllTest("token");
		
		assertEquals(response.getStatusCodeValue(),200);
		assertNotNull(response.getBody());
	}
	
	@Test
	public void getAllTestTestFail() throws Exception
	{
		ResponseEntity<?> response = planTestController.getAllTest("token");
		
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(), "AUTHORIZATION ERROR");
	}
	
	@Test
	public void createTestTestSuccess() throws Exception
	{
		when(planTestServiceImpl.isSessionValid(anyString())).thenReturn(true);
		doNothing().when(planTestServiceImpl).addTest(any(TestDetails.class));
		
		ResponseEntity<?> response = planTestController.createTest("token", new TestDetails());
		
		assertEquals(response.getStatusCodeValue(),200);
		assertEquals(response.getBody(), "CREATED TEST SUCCESSFULLY");
	}
	
	@Test
	public void createTestTestFail() throws Exception
	{
		ResponseEntity<?> response = planTestController.createTest("token", new TestDetails());
		
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(), "AUTHORIZATION ERROR");
	}
	
	@Test
	public void updateTestTestSuccess() throws Exception
	{
		when(planTestServiceImpl.isSessionValid(anyString())).thenReturn(true);
		doNothing().when(planTestServiceImpl).editTest(any(TestDetails.class));
		
		ResponseEntity<?> response = planTestController.updateTest("token", new TestDetails());
		
		assertEquals(response.getStatusCodeValue(),200);
		assertEquals(response.getBody(), "UPDATED TEST SUCCESSFULLY");
	}
	
	@Test
	public void updateTestTestFail() throws Exception
	{
		ResponseEntity<?> response = planTestController.updateTest("token", new TestDetails());
		
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(), "AUTHORIZATION ERROR");
	}
	
	@Test
	public void deleteTestTestSuccess() throws Exception
	{
		when(planTestServiceImpl.isSessionValid(anyString())).thenReturn(true);
		doNothing().when(planTestServiceImpl).removeTest(any(TestDetails.class));
		
		ResponseEntity<?> response = planTestController.deleteTest("token", new TestDetails());
		
		assertEquals(response.getStatusCodeValue(),200);
		assertEquals(response.getBody(), "DELETED TEST SUCCESSFULLY");
	}
	
	@Test
	public void deleteTestTestFail() throws Exception
	{
		ResponseEntity<?> response = planTestController.deleteTest("token", new TestDetails());
		
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(), "AUTHORIZATION ERROR");
	}
	
	@Test
	public void getAllPlanTestSuccess() throws Exception
	{
		when(planTestServiceImpl.isSessionValid(anyString())).thenReturn(true);
		
		ResponseEntity<?> response = planTestController.getAllPlan("token");
		
		assertEquals(response.getStatusCodeValue(),200);
		assertNotNull(response.getBody());
	}
	
	@Test
	public void getAllPlanTestFail() throws Exception
	{
		ResponseEntity<?> response = planTestController.getAllPlan("token");
		
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(), "AUTHORIZATION ERROR");
	}
	
	@Test
	public void createPlanTestSuccess() throws Exception
	{
		when(planTestServiceImpl.isSessionValid(anyString())).thenReturn(true);
		doNothing().when(planTestServiceImpl).addPlan(any(),any());
		
		ResponseEntity<?> response = planTestController.createPlan("token", new PlanTestWrapperObject());
		
		assertEquals(response.getStatusCodeValue(),200);
		assertEquals(response.getBody(), "CREATED PLAN SUCCESSFULLY");
	}
	
	@Test
	public void createPlanTestFail() throws Exception
	{
		ResponseEntity<?> response = planTestController.createPlan("token", new PlanTestWrapperObject());
		
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(), "AUTHORIZATION ERROR");
	}
	
	@Test
	public void updatePlanTestSuccess() throws Exception
	{
		when(planTestServiceImpl.isSessionValid(anyString())).thenReturn(true);
		doNothing().when(planTestServiceImpl).editPlan(any(),any());
		
		ResponseEntity<?> response = planTestController.updatePlan("token", new PlanTestWrapperObject());
		
		assertEquals(response.getStatusCodeValue(),200);
		assertEquals(response.getBody(), "UPDATED PLAN SUCCESSFULLY");
	}
	
	@Test
	public void updatePlanTestFail() throws Exception
	{
		ResponseEntity<?> response = planTestController.updatePlan("token", new PlanTestWrapperObject());
		
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(), "AUTHORIZATION ERROR");
	}
	
	@Test
	public void deletePlanTestSuccess() throws Exception
	{
		when(planTestServiceImpl.isSessionValid(anyString())).thenReturn(true);
		doNothing().when(planTestServiceImpl).removePlan(any(),any());
		
		ResponseEntity<?> response = planTestController.deletePlan("token", new PlanTestWrapperObject());
		
		assertEquals(response.getStatusCodeValue(),200);
		assertEquals(response.getBody(), "DELETED PLAN SUCCESSFULLY");
	}
	
	@Test
	public void deletePlanTestFail() throws Exception
	{
		ResponseEntity<?> response = planTestController.deletePlan("token", new PlanTestWrapperObject());
		
		assertEquals(response.getStatusCodeValue(),403);
		assertEquals(response.getBody(), "AUTHORIZATION ERROR");
	}
	
	@Test
	public void searchAllPlanTestSuccess() throws Exception
	{
		ResponseEntity<?> response = planTestController.searchAllPlan();
		
		assertEquals(response.getStatusCodeValue(),200);
		assertNotNull(response.getBody());
	}
	
	@Test
	public void searchAllPlanTestFail() throws Exception
	{
		doThrow(new NullPointerException()).when(planTestServiceImpl).findAllPlan();
		
		try 
		{
			ResponseEntity<?> response = planTestController.searchAllPlan();
			
			fail();
		}
		catch(NullPointerException e)
		{
			assertTrue(true);
		}
	}

}
