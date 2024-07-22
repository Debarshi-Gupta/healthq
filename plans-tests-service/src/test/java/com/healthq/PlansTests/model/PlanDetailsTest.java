package com.healthq.PlansTests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class PlanDetailsTest {
	
	@Test
	public void idTest() throws Exception
	{
		PlanDetails plan = new PlanDetails();
		plan.setId(10);
		int resultId = plan.getId();
		
		assertEquals(10, resultId);
	}
	
	@Test
	public void planNameTest() throws Exception
	{
		PlanDetails plan = new PlanDetails();
		plan.setPlanName("plan");
		String resultPlanName = plan.getPlanName();
		
		assertEquals("plan", resultPlanName);
	}
	
	@Test
	public void descriptionTest() throws Exception
	{
		PlanDetails plan = new PlanDetails();
		plan.setDescription("description");
		String resultDescription = plan.getDescription();
		
		assertEquals("description", resultDescription);
	}
	
	@Test
	public void planTestMappingTest() throws Exception
	{
		PlanDetails plan = new PlanDetails();
		plan.setPlanTestMapping(new HashSet<PlanTestMapping>());
		Set<PlanTestMapping> resultPlanTestMapping = plan.getPlanTestMapping();
		
		assertNotNull(resultPlanTestMapping);
	}
	
	@Test
	public void constructorTest() throws Exception
	{
		try
		{
			PlanDetails obj1 = new PlanDetails();
			PlanDetails obj2 = new PlanDetails("plan", "description");
			PlanDetails obj3 = new PlanDetails(10, "plan", "description");
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}		
	}

}
