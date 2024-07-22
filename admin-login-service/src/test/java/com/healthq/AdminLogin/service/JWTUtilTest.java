package com.healthq.AdminLogin.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.healthq.AdminLogin.model.AdminDetails;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class JWTUtilTest {
	
	@Autowired
	private AdminDetailsServiceImpl adminDetailsService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Test
	public void contextLoads()
	{
		assertNotNull(jwtUtil);
	}
	
	@Test
	public void generateTokenTestSuccess()
	{
		UserDetails userDetails = adminDetailsService.loadUserByUsername("admin1");
		
		String token = jwtUtil.generateToken(userDetails);
		assertNotNull(token);
	}
	
	@Test
	public void generateTokenTestFail()
	{
		try
		{
		
			UserDetails userDetails = adminDetailsService.loadUserByUsername("randomuser");
		
			String token = jwtUtil.generateToken(userDetails);
			fail();
		}
		catch(UsernameNotFoundException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void extractUsernameTestSuccess() throws Exception
	{
		AdminDetails adminDetails = new AdminDetails(1, "admin1", "13579");
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.content(asJsonString(adminDetails))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		String token = result.getResponse().getContentAsString();
		
		assertEquals("admin1", jwtUtil.extractUsername(token));
	}
	
	@Test
	public void extractUsernameTestFail() throws Exception
	{
		AdminDetails adminDetails = new AdminDetails(1, "admin1", "13579");
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.content(asJsonString(adminDetails))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		String token = result.getResponse().getContentAsString();
		
		assertNotEquals("admin2", jwtUtil.extractUsername(token));
	}
	
	@Test
	public void validateTokenTestSuccess() throws Exception
	{
		AdminDetails adminDetails = new AdminDetails(1, "admin1", "13579");
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.content(asJsonString(adminDetails))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		String token = result.getResponse().getContentAsString();
		
		assertTrue(jwtUtil.validateToken(token));
	}
	
	@Test
	public void validateTokenTestFail() throws Exception
	{
		assertFalse(jwtUtil.validateToken("randomtoken"));
	}
	
	@Test
	public void extractExpirationTestSuccess() throws Exception
	{
		AdminDetails adminDetails = new AdminDetails(1, "admin1", "13579");
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.content(asJsonString(adminDetails))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		String token = result.getResponse().getContentAsString();
		
		assertNotNull(jwtUtil.extractExpiration(token));
	}
	
	@Test
	public void isTokenExpiredTestSuccess() throws Exception
	{
		AdminDetails adminDetails = new AdminDetails(1, "admin1", "13579");
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.content(asJsonString(adminDetails))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		String token = result.getResponse().getContentAsString();
		
		assertFalse(jwtUtil.isTokenExpired(token));
	}
	
	public static String asJsonString(AdminDetails adminDetails)
	{
		try
		{
			return new ObjectMapper().writeValueAsString(adminDetails);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}


}
