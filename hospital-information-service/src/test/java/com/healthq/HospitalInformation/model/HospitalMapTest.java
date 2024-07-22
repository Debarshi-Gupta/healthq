package com.healthq.HospitalInformation.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class HospitalMapTest {
	
	@Test
	public void HospitalTest() throws Exception
	{
		HospitalMap hospitalMap = new HospitalMap();
		hospitalMap.setHospital(new Hospital());
		Hospital resultHospital = hospitalMap.getHospital();
		
		assertNotNull(resultHospital);
	}
	
	@Test
	public void HospitalAddressTest() throws Exception
	{
		HospitalMap hospitalMap = new HospitalMap();
		hospitalMap.setHospitalAddress(new HospitalAddress());
		HospitalAddress resultHospitalAddress = hospitalMap.getHospitalAddress();
		
		assertNotNull(resultHospitalAddress);
	}
	
	@Test
	public void constructorTest() throws Exception
	{
		try
		{
			HospitalMap hospitalMap = new HospitalMap();
			HospitalMap hospitalMap2 = new HospitalMap(new Hospital(), new HospitalAddress());
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}

}
