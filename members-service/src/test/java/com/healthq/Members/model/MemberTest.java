package com.healthq.Members.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class MemberTest {
	
	@Test
	public void idTest() throws Exception
	{
		Member member = new Member();
		member.setId(10);
		int resultId = member.getId();
		
		assertEquals(resultId, 10);
	}
	
	@Test
	public void addressTest() throws Exception
	{
		Member member = new Member();
		member.setAddress("address");
		String resultAddress = member.getAddress();
		
		assertEquals(resultAddress, "address");
	}
	
	@Test
	public void nameTest() throws Exception
	{
		Member member = new Member();
		member.setName("name");
		String resultName = member.getName();
		
		assertEquals(resultName, "name");
	}
	
	@Test
	public void genderTest() throws Exception
	{
		Member member = new Member();
		member.setGender("gender");
		String resultGender = member.getGender();
		
		assertEquals(resultGender, "gender");
	}
	
	@Test
	public void dobTest() throws Exception
	{
		Member member = new Member();
		member.setDob(LocalDate.of(200, 6, 11));
		LocalDate resultDob = member.getDob();
		
		assertEquals(resultDob, LocalDate.of(200, 6, 11));
	}
	
	@Test
	public void contactNumberTest() throws Exception
	{
		Member member = new Member();
		member.setContactNumber(1000);
		long resultContactNumber = member.getContactNumber();
		
		assertEquals(resultContactNumber, 1000);
	}
	
	@Test
	public void emailIdTest() throws Exception
	{
		Member member = new Member();
		member.setEmailId("email");
		String resultEmailId = member.getEmailId();
		
		assertEquals(resultEmailId, "email");
	}
	
	@Test
	public void planIdTest() throws Exception
	{
		Member member = new Member();
		member.setPlanId(10);
		int resultPlanId = member.getPlanId();
		
		assertEquals(resultPlanId, 10);
	}
	
	@Test
	public void planCostTest() throws Exception
	{
		Member member = new Member();
		member.setPlanCost(1000);
		int resultPlanCost = member.getPlanCost();
		
		assertEquals(resultPlanCost, 1000);
	}
	
	@Test
	public void appointmentDateTest() throws Exception
	{
		Member member = new Member();
		member.setAppointmentDate(LocalDateTime.of(200, 6, 11, 9, 0));
		LocalDateTime resultAppointmentDate = member.getAppointmentDate();
		
		assertEquals(resultAppointmentDate, LocalDateTime.of(200, 6, 11, 9, 0));
	}
	
	@Test
	public void hospitalIdTest() throws Exception
	{
		Member member = new Member();
		member.setHospitalId(10);
		int resultHospitalId = member.getHospitalId();
		
		assertEquals(resultHospitalId, 10);
	}
	
	@Test
	public void constructorTest() throws Exception
	{
		try
		{
			Member obj1 = new Member();
			Member obj2 = new Member("Santoshpur, Kolkata", "Dexter Morgan", "Male", LocalDate.of(2000, 11, 6),
				987654321, "dexter@gmail.com", 1, 1000, LocalDateTime.of(2022, 12, 1, 11, 0), 1);
			Member obj3 = new Member(1, "Santoshpur, Kolkata", "Dexter Morgan", "Male", LocalDate.of(2000, 11, 6),
				987654321, "dexter@gmail.com", 1, 1000, LocalDateTime.of(2022, 12, 1, 11, 0), 1);
			
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail();
		}
	}

}
