package com.healthq.HospitalInformation.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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

import com.healthq.HospitalInformation.controller.AuthClient;
import com.healthq.HospitalInformation.model.AuthResponse;
import com.healthq.HospitalInformation.model.Hospital;
import com.healthq.HospitalInformation.model.HospitalAddress;
import com.healthq.HospitalInformation.model.HospitalMap;
import com.healthq.HospitalInformation.repository.HospitalAddressRepository;
import com.healthq.HospitalInformation.repository.HospitalRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class HospitalInformationServiceImplTest {
	
	@InjectMocks
	private HospitalInformationServiceImpl hospitalInformationServiceImpl;
	
	@Mock
	private HospitalRepository hospitalRepository;
	
	@Mock
	private HospitalAddressRepository hospitalAddressRepository;
	
	@Mock
	private AuthClient authClient;
	
	@Test
	public void contextLoads()
	{
		assertNotNull(hospitalInformationServiceImpl);
	}
	
	@Test
	public void getAllHospitalInformationTestSuccess() throws Exception
	{
		HospitalAddress hospitalAddress1 = new HospitalAddress(1, "Nandan Kanan", "Jora Bridge", "Kolkata", 700075, "West Bengal", "India");
		Hospital hospital1 = new Hospital(1, "Amri Hospital", 100, 987654321, "amrihospital@gmail.com");
		hospitalAddress1.setHospital(hospital1);
		hospital1.setHospitalAddress(hospitalAddress1);
		
		List<Hospital> stubList = new ArrayList<>();
		stubList.add(hospital1);
		
		when(hospitalRepository.findAll()).thenReturn(stubList);
		
		List<HospitalMap> hospitalMapList = hospitalInformationServiceImpl.getAllHospitalInformation();
		
		assertNotNull(hospitalMapList);
	}
	
	@Test
	public void getAllHospitalInformationTestFail() throws Exception
	{
		when(hospitalRepository.findAll()).thenReturn(null);
		
		try 
		{
			List<HospitalMap> hospitalMapList = hospitalInformationServiceImpl.getAllHospitalInformation();
			fail();
		}
		catch (NullPointerException e)
		{
			assertTrue(true);
		}
		
	}
	
	@Test
	public void addHospitalInformationTestSuccess() throws Exception
	{
		when(hospitalRepository.save(any(Hospital.class))).thenReturn(null);
		
		hospitalInformationServiceImpl.addHospitalInformation(new Hospital("Random Hospital", 100, 1234567890, "random@gmail.com"), new HospitalAddress("street1", "street2", "location", 123456, "state", "country"));
		
		assertTrue(true);
	}
	
	@Test
	public void addHospitalInformationTestFail() throws Exception
	{
		when(hospitalRepository.save(any(Hospital.class))).thenReturn(null);
		
		try 
		{
			hospitalInformationServiceImpl.addHospitalInformation(null, null);
			fail();
		}
		catch (NullPointerException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void changeHospitalInformationTestSuccess() throws Exception
	{
		when(hospitalRepository.save(any(Hospital.class))).thenReturn(null);
		
		hospitalInformationServiceImpl.changeHospitalInformation(new Hospital(1, "Random Hospital", 100, 1234567890, "random@gmail.com"), new HospitalAddress(1, "street1", "street2", "location", 123456, "state", "country"));
		
		assertTrue(true);
	}
	
	@Test
	public void changeHospitalInformationTestFail() throws Exception
	{
		when(hospitalRepository.save(any(Hospital.class))).thenReturn(null);
		
		try
		{
			hospitalInformationServiceImpl.changeHospitalInformation(null, null);
			fail();
		}
		catch(NullPointerException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void removeHospitalInformationTestSuccess() throws Exception
	{
		doNothing()
		.when(hospitalRepository)
		.deleteById(anyInt());
		
		hospitalInformationServiceImpl.removeHospitalInformation(new Hospital(1, "Random Hospital", 100, 1234567890, "random@gmail.com"), new HospitalAddress(1, "street1", "street2", "location", 123456, "state", "country"));
		
		assertTrue(true);
	}
	
	@Test
	public void removeHospitalInformationTestFail() throws Exception
	{
		doNothing()
		.when(hospitalRepository)
		.deleteById(anyInt());
		
		try
		{
			hospitalInformationServiceImpl.removeHospitalInformation(null, null);
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
		
		boolean result = hospitalInformationServiceImpl.isSessionValid("token");
		
		assertTrue(result);
	}
	
	@Test
	public void isSessionValidTestFail() throws Exception
	{
		doThrow(NullPointerException.class)
		.when(authClient)
		.getValidity(anyString());
		
		assertFalse(hospitalInformationServiceImpl.isSessionValid("token"));
	}
	
	@Test
	public void addDataTestSuccess() throws Exception
	{
		hospitalInformationServiceImpl.addData();
		assertTrue(true);
	}
	
	@Test
	public void addDataTestFail() throws Exception
	{
		hospitalInformationServiceImpl.addData();
		assertTrue(true);
	}

}



