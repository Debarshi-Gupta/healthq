package com.healthq.Members.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.healthq.Members.model.MemberDTO;
import com.healthq.Members.service.MembersServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class MembersControllerTest {
	
	@InjectMocks
	private MembersController membersController;
	
	@Mock
	private MembersServiceImpl membersServiceImpl;
	
	@Test
	public void contextLoads()
	{
		assertNotNull(membersController);
	}
	
	@Test
	public void getAllMembersTestSuccess() throws Exception
	{
		List<MemberDTO> stubList = new ArrayList<>();
		stubList.add(new MemberDTO());
		
		doReturn(stubList).when(membersServiceImpl).findAllMembers();
		
		ResponseEntity<?> response = membersController.getAllMembers();
		
		assertEquals(response.getStatusCodeValue(), 200);
		assertNotNull(response.getBody());
	}
	
	@Test
	public void getAllMembersTestFail() throws Exception
	{
		try 
		{
			doThrow(new NullPointerException()).when(membersServiceImpl).findAllMembers();
			ResponseEntity<?> response = membersController.getAllMembers();
			fail();
		}
		catch (NullPointerException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void createMemberTestSuccess() throws Exception
	{
		doNothing().when(membersServiceImpl).addMember(any());
		
		ResponseEntity<?> response = membersController.createMember(new MemberDTO());
		
		assertEquals(response.getStatusCodeValue(), 200);
		assertEquals(response.getBody(), "CREATED MEMBER SUCCESSFULLY");
	}
	
	@Test
	public void createMemberTestFail() throws Exception
	{
		doThrow(new NullPointerException()).when(membersServiceImpl).addMember(any());
		
		try 
		{
			ResponseEntity<?> response = membersController.createMember(new MemberDTO());
			fail();
		}
		catch (NullPointerException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void updateMemberTestSuccess() throws Exception
	{
		doNothing().when(membersServiceImpl).editMember(any());
		
		ResponseEntity<?> response = membersController.updateMember(new MemberDTO());
		
		assertEquals(response.getStatusCodeValue(), 200);
		assertEquals(response.getBody(), "UPDATED MEMBER SUCCESSFULLY");
	}
	
	@Test
	public void updateMemberTestFail() throws Exception
	{
		doThrow(new NullPointerException()).when(membersServiceImpl).editMember(any());
		
		try 
		{
			ResponseEntity<?> response = membersController.updateMember(new MemberDTO());
			fail();
		}
		catch (NullPointerException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void deleteMemberTestSuccess() throws Exception
	{
		doNothing().when(membersServiceImpl).removeMember(any());
		
		ResponseEntity<?> response = membersController.deleteMember(new MemberDTO());
		
		assertEquals(response.getStatusCodeValue(), 200);
		assertEquals(response.getBody(), "DELETED MEMBER SUCCESSFULLY");
	}
	
	@Test
	public void deleteMemberTestFail() throws Exception
	{
		doThrow(new NullPointerException()).when(membersServiceImpl).removeMember(any());
		
		try 
		{
			ResponseEntity<?> response = membersController.deleteMember(new MemberDTO());
			fail();
		}
		catch (NullPointerException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void getMemberByNameContactNumberTestSuccess() throws Exception
	{
		doReturn(new MemberDTO()).when(membersServiceImpl).searchByNameContactNumber(anyString(), anyInt());
		
		ResponseEntity<?> response = membersController.getMemberByNameContactNumber(new MemberDTO(1, "Santoshpur, Kolkata", "Dexter Morgan", "Male", 6, 11, 2000,
				987654321, "dexter@gmail.com", 1, 1000, 1, 12, 2022, 11, 1));
		
		assertEquals(response.getStatusCodeValue(), 200);
		
	}
	
	@Test
	public void getMemberByNameContactNumberTestFail() throws Exception
	{
		doThrow(new NullPointerException()).when(membersServiceImpl).searchByNameContactNumber(anyString(), anyInt());
		
		
		ResponseEntity<?> response = membersController.getMemberByNameContactNumber(new MemberDTO(1, "Santoshpur, Kolkata", "Dexter Morgan", "Male", 6, 11, 2000,
					987654321, "dexter@gmail.com", 1, 1000, 1, 12, 2022, 11, 1));
		
		assertEquals(response.getStatusCodeValue(), 200);
		
		
	}
	

}
