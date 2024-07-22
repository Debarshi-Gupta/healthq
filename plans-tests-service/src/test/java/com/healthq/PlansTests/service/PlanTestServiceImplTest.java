package com.healthq.PlansTests.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.healthq.PlansTests.controller.AuthClient;
import com.healthq.PlansTests.model.AuthResponse;
import com.healthq.PlansTests.model.PlanDetails;
import com.healthq.PlansTests.model.PlanTestWrapperObject;
import com.healthq.PlansTests.model.TestDetails;
import com.healthq.PlansTests.repository.TestDetailsRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.healthq.PlansTests.repository.PlanDetailsRepository;
import com.healthq.PlansTests.repository.PlanTestMappingRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class PlanTestServiceImplTest {
	
	@InjectMocks
	private PlanTestServiceImpl planTestServiceImpl;
	
	@Mock
	private PlanDetailsRepository planDetailsRepository;
	
	@Mock
	private TestDetailsRepository testDetailsRepository;
	
	@Mock
	private PlanTestMappingRepository planTestMappingRepository;
	
	@Mock
	private AuthClient authClient;
	
	@Test
	public void contextLoads()
	{
		assertNotNull(planTestServiceImpl);
	}
	
	@Test
	public void findAllTestTestSuccess() throws Exception
	{
		List<TestDetails> stubList = new ArrayList<>();
		stubList.add(new TestDetails(1, "Optical Test", "Test For Eye.", "Optical Unit", "Optical Range", 1500));
		
		when(testDetailsRepository.findAll()).thenReturn(stubList);
		
		List<TestDetails> resultList = planTestServiceImpl.findAllTest();
		
		assertNotNull(resultList);
	}
	
	@Test
	public void findAllTestTestFail() throws Exception
	{
		when(testDetailsRepository.findAll()).thenReturn(null);
		
		try 
		{
			List<TestDetails> resultList = planTestServiceImpl.findAllTest();
			fail();
		}
		catch(NullPointerException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void addTestTestSuccess() throws Exception
	{
		doReturn(null).when(testDetailsRepository).save(any(TestDetails.class));
		
		try 
		{
			planTestServiceImpl.addTest(new TestDetails(1, "Optical Test", "Test For Eye.", "Optical Unit", "Optical Range", 1500));
			assertTrue(true);
		}
		catch (Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void addTestTestFail() throws Exception
	{
		doReturn(null).when(testDetailsRepository).save(any(TestDetails.class));
		
		try 
		{
			planTestServiceImpl.addTest(null);
			fail();
		}
		catch (NullPointerException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void editTestTestSuccess() throws Exception
	{
		doReturn(null).when(testDetailsRepository).save(any(TestDetails.class));
		
		try 
		{
			planTestServiceImpl.editTest(new TestDetails(1, "Optical Test", "Test For Eye.", "Optical Unit", "Optical Range", 1500));
			assertTrue(true);
		}
		catch (Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void editTestTestFail() throws Exception
	{
		doReturn(null).when(testDetailsRepository).save(any(TestDetails.class));
		
		try 
		{
			planTestServiceImpl.editTest(null);
			fail();
		}
		catch (NullPointerException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void removeTestTestSuccess() throws Exception
	{
		doNothing().when(testDetailsRepository).deleteById(anyInt());
		
		try 
		{
			planTestServiceImpl.removeTest(new TestDetails(1, "Optical Test", "Test For Eye.", "Optical Unit", "Optical Range", 1500));
			assertTrue(true);
		}
		catch (Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void removeTestTestFail() throws Exception
	{
		doNothing().when(testDetailsRepository).deleteById(anyInt());
		
		try 
		{
			planTestServiceImpl.removeTest(null);
			fail();
		}
		catch (NullPointerException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void findAllPlanTestSuccess() throws Exception
	{
		
		List<PlanTestWrapperObject> resultList = planTestServiceImpl.findAllPlan();
		
		assertNotNull(resultList);	
	}
	
	@Test
	public void findAllPlanTestFail() throws Exception
	{
		doReturn(null).when(planDetailsRepository).findAll();
		
		try 
		{
			List<PlanTestWrapperObject> resultList = planTestServiceImpl.findAllPlan();
			fail();
		}
		catch (NullPointerException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void addPlanTestSuccess() throws Exception
	{
		PlanDetails stubPlan = new PlanDetails(1, "Plan Name", "Plan Description");
		List<TestDetails> stubList = new ArrayList<>();
		stubList.add(new TestDetails(1, "Optical Test", "Test For Eye.", "Optical Unit", "Optical Range", 1500));
		
		doReturn(null).when(planDetailsRepository).save(any(PlanDetails.class));
		
		try 
		{
			planTestServiceImpl.addPlan(stubPlan, stubList);
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void addPlanTestFail() throws Exception
	{
		doReturn(null).when(planDetailsRepository).save(any(PlanDetails.class));
		
		try 
		{
			planTestServiceImpl.addPlan(null, null);
			fail();
		}
		catch (NullPointerException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void editPlanTestSuccess() throws Exception
	{
		PlanDetails stubPlan = new PlanDetails(1, "Plan Name", "Plan Description");
		List<TestDetails> stubList = new ArrayList<>();
		stubList.add(new TestDetails(1, "Optical Test", "Test For Eye.", "Optical Unit", "Optical Range", 1500));
		
		doReturn(null).when(planDetailsRepository).save(any(PlanDetails.class));
		doNothing().when(planDetailsRepository).deleteById(anyInt());
		
		try 
		{
			planTestServiceImpl.editPlan(stubPlan, stubList);
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void editPlanTestFail() throws Exception
	{
		doReturn(null).when(planDetailsRepository).save(any(PlanDetails.class));
		doNothing().when(planDetailsRepository).deleteById(anyInt());
		
		try 
		{
			planTestServiceImpl.editPlan(null, null);
			fail();
		}
		catch(NullPointerException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void removePlanTestSuccess() throws Exception
	{
		PlanDetails stubPlan = new PlanDetails(1, "Plan Name", "Plan Description");
		List<TestDetails> stubList = new ArrayList<>();
		stubList.add(new TestDetails(1, "Optical Test", "Test For Eye.", "Optical Unit", "Optical Range", 1500));
		
		
		doNothing().when(planDetailsRepository).deleteById(anyInt());
		
		try 
		{
			planTestServiceImpl.removePlan(stubPlan, stubList);
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void removePlanTestFail() throws Exception
	{
		doNothing().when(planDetailsRepository).deleteById(anyInt());
		
		try 
		{
			planTestServiceImpl.removePlan(null, null);
			fail();
		}
		catch(NullPointerException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void isSessionValidTestSuccess() throws Exception
	{
		Mockito.doReturn(new AuthResponse())
		.when(authClient)
		.getValidity(anyString());
		
		assertTrue(planTestServiceImpl.isSessionValid("token"));
		
	}
	
	@Test
	public void isSessionValidTestFail() throws Exception
	{
		doThrow(NullPointerException.class)
		.when(authClient)
		.getValidity(anyString());
		
		assertFalse(planTestServiceImpl.isSessionValid("token"));
	}
	
	@Test
	public void addDataTestSuccess() throws Exception
	{
		planTestServiceImpl.addData();
		
		assertTrue(true);
	}
	
	public void addDataTestFail() throws Exception
	{
		planTestServiceImpl.addData();
		
		assertFalse(false);
	}

}
