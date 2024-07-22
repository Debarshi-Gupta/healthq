package com.healthq.PlansTests.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class PlanTestWrapperObjectTest {
	
	@Test
	public void planTest() throws Exception
	{
		PlanTestWrapperObject planTestWrapperObject = new PlanTestWrapperObject();
		planTestWrapperObject.setPlan(new PlanDetails());
		PlanDetails resultPlan = planTestWrapperObject.getPlan();
		
		assertNotNull(resultPlan);
	}
	
	@Test
	public void testListTest() throws Exception
	{
		PlanTestWrapperObject planTestWrapperObject = new PlanTestWrapperObject();
		planTestWrapperObject.setTestList(new ArrayList<TestDetails>());
		List<TestDetails> resultList = planTestWrapperObject.getTestList();
		
		assertNotNull(resultList);
	}
	
	@Test
	public void constructorTest() throws Exception
	{
		try 
		{
			PlanTestWrapperObject obj1 = new PlanTestWrapperObject();
			PlanTestWrapperObject obj2 = new PlanTestWrapperObject(new PlanDetails(), new ArrayList<TestDetails>());
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}

}
