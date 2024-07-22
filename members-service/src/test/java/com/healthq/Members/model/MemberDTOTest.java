package com.healthq.Members.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class MemberDTOTest {
	
	@Test
	public void idTest() throws Exception
	{
		MemberDTO member = new MemberDTO();
		member.setId(10);
		int resultId = member.getId();
		
		assertEquals(resultId, 10);
	}
	
	@Test
	public void addressTest() throws Exception
	{
		MemberDTO member = new MemberDTO();
		member.setAddress("address");
		String resultAddress = member.getAddress();
		
		assertEquals(resultAddress, "address");
	}
	
	@Test
	public void nameTest() throws Exception
	{
		MemberDTO member = new MemberDTO();
		member.setName("name");
		String resultName = member.getName();
		
		assertEquals(resultName, "name");
	}
	
	@Test
	public void genderTest() throws Exception
	{
		MemberDTO member = new MemberDTO();
		member.setGender("gender");
		String resultGender = member.getGender();
		
		assertEquals(resultGender, "gender");
	}
	
	@Test
	public void dobDayTest() throws Exception
	{
		MemberDTO member = new MemberDTO();
		member.setDobDay(20);
		int resultDobDay = member.getDobDay();
		
		assertEquals(resultDobDay, 20);
	}
	
	@Test
	public void dobMonthTest() throws Exception
	{
		MemberDTO member = new MemberDTO();
		member.setDobMonth(5);
		int resultDobMonth = member.getDobMonth();
		
		assertEquals(resultDobMonth, 5);
	}
	
	@Test
	public void dobYearTest() throws Exception
	{
		MemberDTO member = new MemberDTO();
		member.setDobYear(2000);
		int resultDobYear = member.getDobYear();
		
		assertEquals(resultDobYear, 2000);
	}
	
	@Test
	public void contactNumberTest() throws Exception
	{
		MemberDTO member = new MemberDTO();
		member.setContactNumber(1000);
		long resultContactNumber = member.getContactNumber();
		
		assertEquals(resultContactNumber, 1000);
	}
	
	@Test
	public void emailIdTest() throws Exception
	{
		MemberDTO member = new MemberDTO();
		member.setEmailId("email");
		String resultEmailId = member.getEmailId();
		
		assertEquals(resultEmailId, "email");
	}
	
	@Test
	public void planIdTest() throws Exception
	{
		MemberDTO member = new MemberDTO();
		member.setPlanId(10);
		int resultPlanId = member.getPlanId();
		
		assertEquals(resultPlanId, 10);
	}
	
	@Test
	public void planCostTest() throws Exception
	{
		MemberDTO member = new MemberDTO();
		member.setPlanCost(1000);
		int resultPlanCost = member.getPlanCost();
		
		assertEquals(resultPlanCost, 1000);
	}
	
	@Test
	public void appointmentDateDayTest() throws Exception
	{
		MemberDTO member = new MemberDTO();
		member.setAppointmentDateDay(20);
		int resultAppointmentDateDay = member.getAppointmentDateDay();
		
		assertEquals(resultAppointmentDateDay, 20);
	}
	
	@Test
	public void appointmentDateMonthTest() throws Exception
	{
		MemberDTO member = new MemberDTO();
		member.setAppointmentDateMonth(5);
		int resultAppointmentDateMonth = member.getAppointmentDateMonth();
		
		assertEquals(resultAppointmentDateMonth, 5);
	}
	
	@Test
	public void appointmentDateYearTest() throws Exception
	{
		MemberDTO member = new MemberDTO();
		member.setAppointmentDateYear(2023);
		int resultAppointmentDateYear = member.getAppointmentDateYear();
		
		assertEquals(resultAppointmentDateYear, 2023);
	}
	
	@Test
	public void appointmentDateHourTest() throws Exception
	{
		MemberDTO member = new MemberDTO();
		member.setAppointmentDateHour(9);
		int resultAppointmentDateHour = member.getAppointmentDateHour();
		
		assertEquals(resultAppointmentDateHour, 9);
	}
	
	@Test
	public void hospitalIdTest() throws Exception
	{
		MemberDTO member = new MemberDTO();
		member.setHospitalId(10);
		int resultHospitalId = member.getHospitalId();
		
		assertEquals(resultHospitalId, 10);
	}
	
	@Test
	public void constructorTest() throws Exception
	{
		try
		{
			MemberDTO obj1 = new MemberDTO();
			MemberDTO obj2 = new MemberDTO("Santoshpur, Kolkata", "Dexter Morgan", "Male", 2000, 11, 6,
				987654321, "dexter@gmail.com", 1, 1000, 2022, 12, 1, 11, 1);
			MemberDTO obj3 = new MemberDTO(1, "Santoshpur, Kolkata", "Dexter Morgan", "Male", 2000, 11, 6,
					987654321, "dexter@gmail.com", 1, 1000, 2022, 12, 1, 11, 1);
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}

}
