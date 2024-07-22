package com.healthq.Members.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.healthq.Members.model.Member;
import com.healthq.Members.model.MemberDTO;
import com.healthq.Members.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MembersServiceImpl implements MembersService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Transactional
	public List<MemberDTO> findAllMembers()
	{
		List<MemberDTO> returnList = new ArrayList<>();
		
		List<Member> memberList = memberRepository.findAll();
		
		for(Member member:memberList)
		{
			MemberDTO memberDTO = new MemberDTO(member.getId(), member.getAddress(), member.getName(), member.getGender(),
					member.getDob().getDayOfMonth(), member.getDob().getMonthValue(), member.getDob().getYear(),
					member.getContactNumber(), member.getEmailId(), member.getPlanId(), member.getPlanCost(),
					member.getAppointmentDate().getDayOfMonth(), member.getAppointmentDate().getMonthValue(),
					member.getAppointmentDate().getYear(), member.getAppointmentDate().getHour(), member.getHospitalId());
			
			returnList.add(memberDTO);
		}
		
		return returnList;
	}
	
	@Transactional
	public void addMember(MemberDTO memberDTO)
	{
		Member memberObj = new Member(memberDTO.getAddress(), memberDTO.getName(), memberDTO.getGender(),
				LocalDate.of(memberDTO.getDobYear(), memberDTO.getDobMonth(), memberDTO.getDobDay()), 
				memberDTO.getContactNumber(), memberDTO.getEmailId(), memberDTO.getPlanId(), memberDTO.getPlanCost(),
				LocalDateTime.of(memberDTO.getAppointmentDateYear(), memberDTO.getAppointmentDateMonth(), memberDTO.getAppointmentDateDay(), memberDTO.getAppointmentDateHour(), 0),
				memberDTO.getHospitalId());
		
		memberRepository.save(memberObj);
	}
	
	@Transactional
	public void editMember(MemberDTO memberDTO)
	{
		Member memberObj = new Member(memberDTO.getId(), memberDTO.getAddress(), memberDTO.getName(), memberDTO.getGender(),
				LocalDate.of(memberDTO.getDobYear(), memberDTO.getDobMonth(), memberDTO.getDobDay()), 
				memberDTO.getContactNumber(), memberDTO.getEmailId(), memberDTO.getPlanId(), memberDTO.getPlanCost(),
				LocalDateTime.of(memberDTO.getAppointmentDateYear(), memberDTO.getAppointmentDateMonth(), memberDTO.getAppointmentDateDay(), memberDTO.getAppointmentDateHour(), 0),
				memberDTO.getHospitalId());
		
		memberRepository.save(memberObj);
	}
	
	@Transactional
	public void removeMember(MemberDTO memberDTO)
	{
		memberRepository.deleteById(memberDTO.getId());
	}
	
	@Transactional
	public MemberDTO searchByNameContactNumber(String name, long contactNumber)
	{
		Member member = memberRepository.findByNameContactNumber(name, contactNumber);
		
		MemberDTO memberDTO = new MemberDTO(member.getId(), member.getAddress(), member.getName(), member.getGender(),
				member.getDob().getDayOfMonth(), member.getDob().getMonthValue(), member.getDob().getYear(),
				member.getContactNumber(), member.getEmailId(), member.getPlanId(), member.getPlanCost(),
				member.getAppointmentDate().getDayOfMonth(), member.getAppointmentDate().getMonthValue(),
				member.getAppointmentDate().getYear(), member.getAppointmentDate().getHour(), member.getHospitalId());
		
		return memberDTO;
	}
	
	@Transactional
	public void addData()
	{
		Member member1 = new Member(1, "Santoshpur, Kolkata", "Dexter Morgan", "Male", LocalDate.of(2000, 11, 6),
				987654321, "dexter@gmail.com", 1, 1000, LocalDateTime.of(2022, 12, 1, 11, 0), 1);
		memberRepository.save(member1);
		
		Member member2 = new Member(2, "Maktala, Chennal", "Hannibal Lecter", "Male", LocalDate.of(1990, 4, 24),
				123456789, "hannibal@gmail.com", 2, 2500, LocalDateTime.of(2022, 12, 2, 14, 0), 1);
		memberRepository.save(member2);
		
		Member member3 = new Member(3, "Ecospace, Bangalore", "Lucifer Morningstar", "Male", LocalDate.of(1995, 8, 15),
				99999999, "lucifer@gmail.com", 3, 4500, LocalDateTime.of(2022, 12, 3, 9, 0), 1);
		memberRepository.save(member3);
		
		
	}

}
