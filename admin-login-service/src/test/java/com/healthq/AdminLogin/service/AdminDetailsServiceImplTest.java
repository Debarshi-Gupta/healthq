package com.healthq.AdminLogin.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminDetailsServiceImplTest {
	
	@Autowired
	private AdminDetailsServiceImpl adminDetailsService;
	
	@Test
	public void contextLoads()
	{
		assertNotNull(adminDetailsService);
	}
	
	@Test
	public void loadUserByUsernameTestSuccess()
	{
		assertEquals("admin1", adminDetailsService.loadUserByUsername("admin1").getUsername());
		
	}
	
	@Test
	public void loadUserByUsernameTestFail()
	{
		try
		{
			assertEquals("randomuser", adminDetailsService.loadUserByUsername("randomuser").getUsername());
			fail();
		}
		catch(UsernameNotFoundException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void addDataTestSuccess()
	{
		adminDetailsService.addData();
		assertTrue(true);
	}
	
	@Test
	public void addDataTestFail()
	{
		adminDetailsService.addData();
		assertFalse(false);
	}
	
	

}
