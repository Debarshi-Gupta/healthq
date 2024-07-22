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
public class HospitalAddressTest {
	
	@Test
	public void idTest() throws Exception
	{
		HospitalAddress hospitalAddress = new HospitalAddress();
		hospitalAddress.setId(10);
		int resultId = hospitalAddress.getId();
		
		assertEquals(10, resultId);
	}
	
	@Test
	public void streetLine1Test() throws Exception
	{
		HospitalAddress hospitalAddress = new HospitalAddress();
		hospitalAddress.setStreetLine1("street1");
		String resultStreetLine1 = hospitalAddress.getStreetLine1();
		
		assertEquals("street1", resultStreetLine1);
	}
	
	@Test
	public void streetLine2Test() throws Exception
	{
		HospitalAddress hospitalAddress = new HospitalAddress();
		hospitalAddress.setStreetLine2("street2");
		String resultStreetLine2 = hospitalAddress.getStreetLine2();
		
		assertEquals("street2", resultStreetLine2);
	}
	
	@Test
	public void locationTest() throws Exception
	{
		HospitalAddress hospitalAddress = new HospitalAddress();
		hospitalAddress.setLocation("location");
		String resultLocation = hospitalAddress.getLocation();
		
		assertEquals("location", resultLocation);
	}
	
	@Test
	public void pincodeTest() throws Exception
	{
		HospitalAddress hospitalAddress = new HospitalAddress();
		hospitalAddress.setPincode(10);
		int resultPincode = hospitalAddress.getPincode();
		
		assertEquals(10, resultPincode);
	}
	
	@Test
	public void stateTest() throws Exception
	{
		HospitalAddress hospitalAddress = new HospitalAddress();
		hospitalAddress.setState("state");
		String resultState = hospitalAddress.getState();
		
		assertEquals("state", resultState);
	}
	
	@Test
	public void countryTest() throws Exception
	{
		HospitalAddress hospitalAddress = new HospitalAddress();
		hospitalAddress.setCountry("country");
		String resultCountry = hospitalAddress.getCountry();
		
		assertEquals("country", resultCountry);
	}
	
	@Test
	public void hospitalTest() throws Exception
	{
		HospitalAddress hospitalAddress = new HospitalAddress();
		hospitalAddress.setHospital(new Hospital());
		Hospital resultHospital = hospitalAddress.getHospital();
		
		assertNotNull(resultHospital);
	}
	
	@Test
	public void constructorTest() throws Exception
	{
		try
		{
			HospitalAddress hospitalAddress = new HospitalAddress();
			HospitalAddress hospitalAddress2 = new HospitalAddress("street1", "street2", "location", 200, "state", "country");
			HospitalAddress hospitalAddress3 = new HospitalAddress(10, "street1", "street2", "location", 200, "state", "country");
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}

}
