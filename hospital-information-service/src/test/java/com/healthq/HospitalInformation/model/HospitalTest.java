package com.healthq.HospitalInformation.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class HospitalTest {
	
	@Test
	public void idTest() throws Exception
	{
		Hospital hospital = new Hospital();
		hospital.setId(10);
		int resultId = hospital.getId();
		
		assertEquals(10, resultId);
	}
	
	@Test
	public void hospitalNameTest() throws Exception
	{
		Hospital hospital = new Hospital();
		hospital.setHospitalName("name");
		String resultHospitalName = hospital.getHospitalName();
		
		assertEquals("name", resultHospitalName);
	}
	
	@Test
	public void appointmentsPerDayTest() throws Exception
	{
		Hospital hospital = new Hospital();
		hospital.setAppointmentsPerDay(10);
		int resultAppointmentsPerDay = hospital.getAppointmentsPerDay();
		
		assertEquals(10, resultAppointmentsPerDay);
	}
	
	@Test
	public void contactNumberTest() throws Exception
	{
		Hospital hospital = new Hospital();
		hospital.setContactNumber(10);
		long resultContactNumber = hospital.getContactNumber();
		
		assertEquals(10, resultContactNumber);
	}
	
	@Test
	public void emailIdTest() throws Exception
	{
		Hospital hospital = new Hospital();
		hospital.setEmailId("email");
		String resultEmailId = hospital.getEmailId();
		
		assertEquals("email", resultEmailId);
	}
	
	@Test
	public void hospitalAddressTest() throws Exception
	{
		Hospital hospital = new Hospital();
		hospital.setHospitalAddress(new HospitalAddress());
		HospitalAddress resultHospitalAddress = hospital.getHospitalAddress();
		
		assertNotNull(resultHospitalAddress);
	}
	
	@Test
	public void constructorTest() throws Exception
	{
		try 
		{
			Hospital hospital = new Hospital();
			Hospital hospital2 = new Hospital("name", 200, 100, "email");
			Hospital hospital3 = new Hospital(10, "name", 200, 100, "email");
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}

}
