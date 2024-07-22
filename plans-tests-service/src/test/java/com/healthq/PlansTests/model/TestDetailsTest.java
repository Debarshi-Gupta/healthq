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
public class TestDetailsTest {
	
	@Test
	public void idTest() throws Exception
	{
		TestDetails test = new TestDetails();
		test.setId(10);
		int resultId = test.getId();
		
		assertEquals(resultId, 10);
	}
	
	@Test
	public void testNameTest() throws Exception
	{
		TestDetails test = new TestDetails();
		test.setTestName("test");
		String resultTestName = test.getTestName();
		
		assertEquals(resultTestName, "test");
	}
	
	@Test
	public void descriptionTest() throws Exception
	{
		TestDetails test = new TestDetails();
		test.setDescription("description");
		String resultDescription = test.getDescription();
		
		assertEquals(resultDescription, "description");
	}
	
	@Test
	public void unitTest() throws Exception
	{
		TestDetails test = new TestDetails();
		test.setUnit("unit");
		String resultUnit = test.getUnit();
		
		assertEquals(resultUnit, "unit");
	}
	
	@Test
	public void rangeTest() throws Exception
	{
		TestDetails test = new TestDetails();
		test.setRange("range");
		String resultRange = test.getRange();
		
		assertEquals(resultRange, "range");
	}
	
	@Test
	public void priceTest() throws Exception
	{
		TestDetails test = new TestDetails();
		test.setPrice(1000);
		int resultPrice = test.getPrice();
		
		assertEquals(resultPrice, 1000);
	}
	
	@Test
	public void planTestMappingTest() throws Exception
	{
		TestDetails test = new TestDetails();
		test.setPlanTestMapping(new HashSet<PlanTestMapping>());
		Set<PlanTestMapping> resultPlanTestMapping = test.getPlanTestMapping();
		
		assertNotNull(resultPlanTestMapping);
	}
	
	@Test
	public void constructorTest() throws Exception
	{
		try
		{
			TestDetails obj1 = new TestDetails();
			TestDetails obj2 = new TestDetails("Optical Test", "Test For Eye.", "Optical Unit", "Optical Range", 1000);
			TestDetails obj3 = new TestDetails(10, "Optical Test", "Test For Eye.", "Optical Unit", "Optical Range", 1000);
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}

}
