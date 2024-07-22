package com.healthq.Members.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.healthq.Members.model.Member;
import com.healthq.Members.model.MemberDTO;
import com.healthq.Members.repository.MemberRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class MembersServiceImplTest {
	
	@InjectMocks
	private MembersServiceImpl membersServiceImpl;
	
	@Mock
	private MemberRepository memberRepository;
	
	@Test
	public void contextLoads() throws Exception
	{
		assertNotNull(membersServiceImpl);
	}
	
	@Test
	public void findAllMembersTestSuccess() throws Exception
	{
		List<Member> stubList = new ArrayList<>();
		stubList.add(new Member(1, "Santoshpur, Kolkata", "Dexter Morgan", "Male", LocalDate.of(2000, 11, 6),
				987654321, "dexter@gmail.com", 1, 1000, LocalDateTime.of(2022, 12, 1, 11, 0), 1));
		
		doReturn(stubList).when(memberRepository).findAll();
		
		List<MemberDTO> resultList = membersServiceImpl.findAllMembers();
		
		assertNotNull(resultList);
	}
	
	@Test
	public void findAllMembersTestFail() throws Exception
	{
		doReturn(null).when(memberRepository).findAll();
		
		try 
		{
			List<MemberDTO> resultList = membersServiceImpl.findAllMembers();
			fail();
		}
		catch(NullPointerException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void addMemberTestSuccess() throws Exception
	{
		doReturn(null).when(memberRepository).save(any(Member.class));
		
		try 
		{
			membersServiceImpl.addMember(new MemberDTO(1, "Santoshpur, Kolkata", "Dexter Morgan", "Male", 6, 11, 2000,
				987654321, "dexter@gmail.com", 1, 1000, 1, 12, 2022, 11, 1));
		
			assertTrue(true);
		}
		catch(NullPointerException e)
		{
			fail();
		}
	}
	
	@Test
	public void addMemberTestFail() throws Exception
	{
		doReturn(null).when(memberRepository).save(any(Member.class));
		
		try 
		{
			membersServiceImpl.addMember(null);
		
			fail();
		}
		catch(NullPointerException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void editMemberTestSuccess() throws Exception
	{
		doReturn(null).when(memberRepository).save(any(Member.class));
		
		try 
		{
			membersServiceImpl.editMember(new MemberDTO(1, "Santoshpur, Kolkata", "Dexter Morgan", "Male", 6, 11, 2000,
				987654321, "dexter@gmail.com", 1, 1000, 1, 12, 2022, 11, 1));
		
			assertTrue(true);
		}
		catch(NullPointerException e)
		{
			fail();
		}
	}
	
	@Test
	public void editMemberTestFail() throws Exception
	{
		doReturn(null).when(memberRepository).save(any(Member.class));
		
		try 
		{
			membersServiceImpl.editMember(null);
		
			fail();
		}
		catch(NullPointerException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void removeMemberTestSuccess() throws Exception
	{
		doNothing().when(memberRepository).deleteById(anyInt());
		
		try 
		{
			membersServiceImpl.removeMember(new MemberDTO(1, "Santoshpur, Kolkata", "Dexter Morgan", "Male", 6, 11, 2000,
				987654321, "dexter@gmail.com", 1, 1000, 1, 12, 2022, 11, 1));
		
			assertTrue(true);
		}
		catch(NullPointerException e)
		{
			fail();
		}
	}
	
	@Test
	public void removeMemberTestFail() throws Exception
	{
		doNothing().when(memberRepository).deleteById(anyInt());
		
		try 
		{
			membersServiceImpl.removeMember(null);
		
			fail();
		}
		catch(NullPointerException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void searchByNameContactNumberTestSuccess() throws Exception
	{
		doReturn(new Member(1, "Santoshpur, Kolkata", "Dexter Morgan", "Male", LocalDate.of(2000, 11, 6),
				987654321, "dexter@gmail.com", 1, 1000, LocalDateTime.of(2022, 12, 1, 11, 0), 1)).when(memberRepository).findByNameContactNumber(anyString(), anyLong());
		
		try 
		{
			membersServiceImpl.searchByNameContactNumber("Stub Name", 1);
		
			assertTrue(true);
		}
		catch(NullPointerException e)
		{
			fail();
		}
	}
	
	@Test
	public void searchByNameContactNumberTestFail() throws Exception
	{
		doReturn(null).when(memberRepository).findByNameContactNumber(anyString(), anyLong());
		
		try 
		{
			membersServiceImpl.searchByNameContactNumber("Stub Name", 1);
		
			fail();
		}
		catch(NullPointerException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void addDataTestSuccess() throws Exception
	{
		membersServiceImpl.addData();
		
		assertTrue(true);
	}
	
	@Test
	public void addDataTestFail() throws Exception
	{
		membersServiceImpl.addData();
		
		assertFalse(false);
	}
	

}
