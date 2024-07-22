package com.healthq.AdminLogin.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminDetailsTest {
	
	@Test
	public void idTest() throws Exception
	{
		AdminDetails adminDetails = new AdminDetails();
		adminDetails.setId(10);
		int resultId = adminDetails.getId();
		
		assertEquals(resultId, 10);
	}
	
	@Test
	public void usernameTest() throws Exception
	{
		AdminDetails adminDetails = new AdminDetails();
		adminDetails.setUsername("random user");
		String resultUsername = adminDetails.getUsername();
		
		assertEquals(resultUsername, "random user");
	}
	
	@Test
	public void passwordTest() throws Exception
	{
		AdminDetails adminDetails = new AdminDetails();
		adminDetails.setPassword("12345");
		String resultPassword = adminDetails.getPassword();
		
		assertEquals(resultPassword, "12345");
	}
	
	@Test
	public void constructorTest() throws Exception
	{
		try
		{
			AdminDetails obj1 = new AdminDetails();
			AdminDetails obj2 = new AdminDetails(10, "username", "password");
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
		
		
		
	}

}
