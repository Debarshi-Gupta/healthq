package com.healthq.HospitalInformation.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import com.healthq.HospitalInformation.model.HospitalMap;
import com.healthq.HospitalInformation.service.HospitalInformationServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class HospitalInformationControllerTest {
	
	@InjectMocks
	private HospitalInformationController hospitalInformationController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private HospitalInformationServiceImpl hospitalInformationServiceImpl;
	
	@Test
	public void contextLoads()
	{
		assertNotNull(hospitalInformationController);
	}
	
	@Test
	public void findAllHospitalInformationTestSuccess() throws Exception
	{
		when(hospitalInformationServiceImpl.isSessionValid(anyString())).thenReturn(true);
		
		ResponseEntity<?> responseEntity = hospitalInformationController.findAllHospitalInformation("token");
		
		assertEquals(responseEntity.getStatusCodeValue(),200);
		assertNotNull(responseEntity.getBody());
		
	}
	
	@Test
	public void findAllHospitalInformationTestFail() throws Exception
	{
		ResponseEntity<?> responseEntity = hospitalInformationController.findAllHospitalInformation("token");
		
		assertNotEquals(responseEntity.getStatusCodeValue(),200);
		assertEquals(responseEntity.getBody(),"AUTHORIZATION ERROR");
	}
	
	@Test
	public void createHospitalTestSuccess() throws Exception
	{
		when(hospitalInformationServiceImpl.isSessionValid(anyString())).thenReturn(true);
		
		ResponseEntity<?> responseEntity = hospitalInformationController.createHospital("token", new HospitalMap());
		
		assertEquals(responseEntity.getStatusCodeValue(),200);
		assertEquals(responseEntity.getBody(),"CREATED HOSPITAL SUCCESSFULLY");
	}
	
	@Test
	public void createHospitalTestFail() throws Exception
	{
		ResponseEntity<?> responseEntity = hospitalInformationController.createHospital("token", new HospitalMap());
		
		assertNotEquals(responseEntity.getStatusCodeValue(),200);
		assertEquals(responseEntity.getBody(),"AUTHORIZATION ERROR");
	}
	
	@Test
	public void updateHospitalTestSuccess() throws Exception
	{
		when(hospitalInformationServiceImpl.isSessionValid(anyString())).thenReturn(true);
		
		ResponseEntity<?> responseEntity = hospitalInformationController.updateHospital("token", new HospitalMap());
		
		assertEquals(responseEntity.getStatusCodeValue(),200);
		assertEquals(responseEntity.getBody(),"UPDATED HOSPITAL SUCCESSFULLY");
	}
	
	@Test
	public void updateHospitalTestFail() throws Exception
	{
		ResponseEntity<?> responseEntity = hospitalInformationController.updateHospital("token", new HospitalMap());
		
		assertNotEquals(responseEntity.getStatusCodeValue(),200);
		assertEquals(responseEntity.getBody(),"AUTHORIZATION ERROR");
	}
	
	@Test
	public void deleteHospitalTestSuccess() throws Exception
	{
		when(hospitalInformationServiceImpl.isSessionValid(anyString())).thenReturn(true);
		
		ResponseEntity<?> responseEntity = hospitalInformationController.deleteHospital("token", new HospitalMap());
		
		assertEquals(responseEntity.getStatusCodeValue(),200);
		assertEquals(responseEntity.getBody(),"DELETED HOSPITAL SUCCESSFULLY");
	}
	
	@Test
	public void deleteHospitalTestFail() throws Exception
	{
		ResponseEntity<?> responseEntity = hospitalInformationController.deleteHospital("token", new HospitalMap());
		
		assertNotEquals(responseEntity.getStatusCodeValue(),200);
		assertEquals(responseEntity.getBody(),"AUTHORIZATION ERROR");
	}
	
	@Test
	public void searchAllHospitalTestSuccess() throws Exception
	{
		ResponseEntity<?> response = hospitalInformationController.searchAllHospital();
		
		assertEquals(response.getStatusCodeValue(), 200);
		assertNotNull(response.getBody());	
	}
	
	@Test
	public void searchAllHospitalTestFail() throws Exception
	{
		doThrow(new NullPointerException()).when(hospitalInformationServiceImpl).getAllHospitalInformation();
		
		try 
		{
			ResponseEntity<?> response = hospitalInformationController.searchAllHospital();
			fail();
		}
		catch(NullPointerException e)
		{
			assertTrue(true);
		}
	}

}
