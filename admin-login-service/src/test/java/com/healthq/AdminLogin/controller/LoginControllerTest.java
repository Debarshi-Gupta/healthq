package com.healthq.AdminLogin.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.healthq.AdminLogin.model.AdminDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private LoginController loginController;
	
	@Test
	public void contextLoads()
	{
		assertNotNull(loginController);
	}
	
	@Test
	public void loginTestSuccess() throws Exception
	{
		AdminDetails adminDetails = new AdminDetails(1, "admin1", "13579");
		
		mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.content(asJsonString(adminDetails))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void loginTestFail() throws Exception
	{
		AdminDetails adminDetails = new AdminDetails(1, "admin1", "12345");
		
		mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.content(asJsonString(adminDetails))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isForbidden());
	}
	
	@Test
	public void validateTestSuccess() throws Exception
	{
		AdminDetails adminDetails = new AdminDetails(1, "admin1", "13579");
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.content(asJsonString(adminDetails))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		String token = result.getResponse().getContentAsString();
		
		mockMvc.perform(MockMvcRequestBuilders.get("/validate")
				.header("Authorization", "Bearer " + token))
				.andExpect(status().isOk());
	}
	
	@Test
	public void validateTestFail() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/validate")
				.header("Authorization", "random token"))
				.andExpect(status().isForbidden());
		
		ResponseEntity<?> response = loginController.getValidity(null);
		
		assertEquals(403, response.getStatusCodeValue());
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
