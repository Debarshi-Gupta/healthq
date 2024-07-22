package com.healthq.Members.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.healthq.Members.model.MemberDTO;
import com.healthq.Members.service.MembersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MembersController {
	
	@Autowired
	private MembersServiceImpl membersServiceImpl;
	
	@GetMapping("/getAllMembers")
	public ResponseEntity<?> getAllMembers()
	{
		List<MemberDTO> memberList = membersServiceImpl.findAllMembers();
		
		return new ResponseEntity<>(memberList, HttpStatus.OK);
	}
	
	@PostMapping("/createMember")
	public ResponseEntity<?> createMember(@RequestBody @NotNull MemberDTO memberDTO)
	{
		membersServiceImpl.addMember(memberDTO);
		
		return new ResponseEntity<>("CREATED MEMBER SUCCESSFULLY", HttpStatus.OK);
	}
	
	@PostMapping("/updateMember")
	public ResponseEntity<?> updateMember(@RequestBody @NotNull MemberDTO memberDTO)
	{
		membersServiceImpl.editMember(memberDTO);
		
		return new ResponseEntity<>("UPDATED MEMBER SUCCESSFULLY", HttpStatus.OK);
	}
	
	@PostMapping("/deleteMember")
	public ResponseEntity<?> deleteMember(@RequestBody @NotNull MemberDTO memberDTO)
	{
		membersServiceImpl.removeMember(memberDTO);
		
		return new ResponseEntity<>("DELETED MEMBER SUCCESSFULLY", HttpStatus.OK);
	}
	
	@PostMapping("/getMemberByNameContactNumber")
	public ResponseEntity<?> getMemberByNameContactNumber(@RequestBody @NotNull MemberDTO memberDTO)
	{
		return new ResponseEntity<>(membersServiceImpl.searchByNameContactNumber(memberDTO.getName(), memberDTO.getContactNumber()), HttpStatus.OK);
	}

}
