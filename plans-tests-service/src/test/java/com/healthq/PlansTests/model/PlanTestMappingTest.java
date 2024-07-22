package com.healthq.PlansTests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class PlanTestMappingTest {
	
	@Test
	public void idTest() throws Exception
	{
		PlanTestMapping planTestMapping = new PlanTestMapping();
		planTestMapping.setId(10);
		int resultId = planTestMapping.getId();
		
		assertEquals(10, resultId);
	}
	
	@Test
	public void planDetailsTest() throws Exception
	{
		PlanTestMapping planTestMapping = new PlanTestMapping();
		planTestMapping.setPlan(new PlanDetails());
		PlanDetails resultPlan = planTestMapping.getPlan();
		
		assertNotNull(resultPlan);
	}
	
	@Test
	public void testDetailsTest() throws Exception
	{
		PlanTestMapping planTestMapping = new PlanTestMapping();
		planTestMapping.setTest(new TestDetails());
		TestDetails resultTest = planTestMapping.getTest();
		
		assertNotNull(resultTest);
	}
	
	@Test
	public void constructorTest() throws Exception
	{
		try 
		{
			PlanTestMapping obj1 = new PlanTestMapping();
			PlanTestMapping obj2 = new PlanTestMapping(new PlanDetails(), new TestDetails());
			PlanTestMapping obj3 = new PlanTestMapping(10, new PlanDetails(), new TestDetails());
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}

}
