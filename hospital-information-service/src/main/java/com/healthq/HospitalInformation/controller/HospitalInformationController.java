package com.healthq.HospitalInformation.controller;

import javax.validation.constraints.NotNull;

import com.healthq.HospitalInformation.model.HospitalMap;
import com.healthq.HospitalInformation.service.HospitalInformationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HospitalInformationController {
	
	@Autowired
	private HospitalInformationServiceImpl hospitalInformationServiceImpl;
	
	private Logger logger = LoggerFactory.getLogger(HospitalInformationController.class);
	
	
	@GetMapping("/getAllHospitalInformation")
	public ResponseEntity<?> findAllHospitalInformation(@RequestHeader("Authorization") @NotNull String token)
	{
		logger.info("METHOD EXECUTION START");
		
		if(hospitalInformationServiceImpl.isSessionValid(token))
		{
			logger.info("METHOD EXECUTION END - RETRIEVED HOSPITAL SUCCESSFULLY");
			
			return new ResponseEntity<>(hospitalInformationServiceImpl.getAllHospitalInformation(), HttpStatus.OK);
		}
		
		logger.info("METHOD EXECUTION END - AUTHORIZATION ERROR");
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	
	@PostMapping("/createHospital")
	public ResponseEntity<?> createHospital(@RequestHeader("Authorization") @NotNull String token, @RequestBody @NotNull HospitalMap hospitalMap)
	{
		logger.info("METHOD EXECUTION START");
		
		if(hospitalInformationServiceImpl.isSessionValid(token))
		{
			hospitalInformationServiceImpl.addHospitalInformation(hospitalMap.getHospital(), hospitalMap.getHospitalAddress());
			
			logger.info("METHOD EXECUTION END - CREATED HOSPITAL SUCCESSFULLY");
			
			return new ResponseEntity<>("CREATED HOSPITAL SUCCESSFULLY", HttpStatus.OK);
		}
		
		logger.info("METHOD EXECUTION END - AUTHORIZATION ERROR");
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	
	@PostMapping("/updateHospital")
	public ResponseEntity<?> updateHospital(@RequestHeader("Authorization") @NotNull String token, @RequestBody @NotNull HospitalMap hospitalMap)
	{
		logger.info("METHOD EXECUTION START");
		
		if(hospitalInformationServiceImpl.isSessionValid(token))
		{
			hospitalInformationServiceImpl.changeHospitalInformation(hospitalMap.getHospital(), hospitalMap.getHospitalAddress());
			
			logger.info("METHOD EXECUTION END - UPDATED HOSPITAL SUCCESSFULLY");
			
			return new ResponseEntity<>("UPDATED HOSPITAL SUCCESSFULLY", HttpStatus.OK);
		}
		
		logger.info("METHOD EXECUTION END - AUTHORIZATION ERROR");
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}
	
	
	@PostMapping("/deleteHospital")
	public ResponseEntity<?> deleteHospital(@RequestHeader("Authorization") @NotNull String token, @RequestBody @NotNull HospitalMap hospitalMap)
	{
		logger.info("METHOD EXECUTION START");
		
		if(hospitalInformationServiceImpl.isSessionValid(token))
		{
			hospitalInformationServiceImpl.removeHospitalInformation(hospitalMap.getHospital(),hospitalMap.getHospitalAddress());
			
			logger.info("METHOD EXECUTION END - DELETED HOSPITAL SUCCESSFULLY");
			
			return new ResponseEntity<>("DELETED HOSPITAL SUCCESSFULLY", HttpStatus.OK);
		}
		
		logger.info("METHOD EXECUTION END - AUTHORIZATION ERROR");
		
		return new ResponseEntity<>("AUTHORIZATION ERROR", HttpStatus.FORBIDDEN);
	}

	@GetMapping("/searchAllHospitalInformation")
	public ResponseEntity<?> searchAllHospital()
	{
		logger.info("METHOD EXECUTION START");
		
		logger.info("METHOD EXECUTION END - RETRIEVED HOSPITALS SUCCESSFULLY");
		
		return new ResponseEntity<>(hospitalInformationServiceImpl.getAllHospitalInformation(), HttpStatus.OK);
	}

}
