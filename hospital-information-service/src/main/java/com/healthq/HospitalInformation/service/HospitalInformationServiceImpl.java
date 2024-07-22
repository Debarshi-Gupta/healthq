package com.healthq.HospitalInformation.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthq.HospitalInformation.controller.AuthClient;
import com.healthq.HospitalInformation.model.AuthResponse;
import com.healthq.HospitalInformation.model.Hospital;
import com.healthq.HospitalInformation.model.HospitalAddress;
import com.healthq.HospitalInformation.model.HospitalMap;
import com.healthq.HospitalInformation.repository.HospitalAddressRepository;
import com.healthq.HospitalInformation.repository.HospitalRepository;

@Service
public class HospitalInformationServiceImpl implements HospitalInformationService {
	
	@Autowired
	private AuthClient authClient;
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Autowired
	private HospitalAddressRepository hospitalAddressRepository;
	
	private Logger logger = LoggerFactory.getLogger(HospitalInformationServiceImpl.class);
	
	@Transactional
	public List<HospitalMap> getAllHospitalInformation()
	{
		logger.info("METHOD EXECUTION START");
		
		List<Hospital> hospitals = hospitalRepository.findAll();
		
		List<HospitalMap> hospitalMapList = new ArrayList<>();
		
		for (Hospital hospital : hospitals)
		{
			Hospital hospitalObj = new Hospital(hospital.getId(), hospital.getHospitalName(), hospital.getAppointmentsPerDay(), hospital.getContactNumber(), hospital.getEmailId());
			hospitalObj.setHospitalAddress(null);
			HospitalAddress hospitalAddressObj = new HospitalAddress(hospital.getHospitalAddress().getId(), hospital.getHospitalAddress().getStreetLine1(), hospital.getHospitalAddress().getStreetLine2(), hospital.getHospitalAddress().getLocation(), hospital.getHospitalAddress().getPincode(), hospital.getHospitalAddress().getState(), hospital.getHospitalAddress().getCountry());
			hospitalAddressObj.setHospital(null);
			hospitalMapList.add(new HospitalMap(hospitalObj, hospitalAddressObj));
		}
		
		logger.info("METHOD EXECUTION END - RETURNED HOSPITAL INFORMATION SUCCESSFULLY");
		
		return hospitalMapList;
	}
	
	
	@Transactional
	public void addHospitalInformation(Hospital hospital, HospitalAddress hospitalAddress)
	{
		logger.info("METHOD EXECUTION START");
		
		Hospital hospitalObject = new Hospital(hospital.getHospitalName(), hospital.getAppointmentsPerDay(), hospital.getContactNumber(), hospital.getEmailId());
		HospitalAddress hospitalAddressObject = new HospitalAddress(hospitalAddress.getStreetLine1(), hospitalAddress.getStreetLine2(), hospitalAddress.getLocation(), hospitalAddress.getPincode(), hospitalAddress.getState(), hospitalAddress.getCountry());
		
		hospitalObject.setHospitalAddress(hospitalAddressObject);
		hospitalAddressObject.setHospital(hospitalObject);
		
		hospitalRepository.save(hospitalObject);
		
		logger.info("METHOD EXECUTION END - ADDED HOSPITAL SUCCESSFULLY");
	}
	
	
	@Transactional
	public void changeHospitalInformation(Hospital hospital, HospitalAddress hospitalAddress)
	{
		logger.info("METHOD EXECUTION START");
		
		Hospital hospitalObject = new Hospital(hospital.getId(), hospital.getHospitalName(), hospital.getAppointmentsPerDay(), hospital.getContactNumber(), hospital.getEmailId());
		HospitalAddress hospitalAddressObject = new HospitalAddress(hospitalAddress.getId(), hospitalAddress.getStreetLine1(), hospitalAddress.getStreetLine2(), hospitalAddress.getLocation(), hospitalAddress.getPincode(), hospitalAddress.getState(), hospitalAddress.getCountry());
		
		hospitalObject.setHospitalAddress(hospitalAddressObject);
		hospitalAddressObject.setHospital(hospitalObject);
		
		hospitalRepository.save(hospitalObject);
		
		logger.info("METHOD EXECUTION END - CHANGED HOSPITAL SUCCESSFULLY ");
	}
	
	
	@Transactional
	public void removeHospitalInformation(Hospital hospital, HospitalAddress hospitalAddress)
	{
		logger.info("METHOD EXECUTION START");
		
		hospitalRepository.deleteById(hospital.getId());
		
		logger.info("METHOD EXECUTION END - REMOVED HOSPITAL SUCCESFULLY ");
	}
	
	
	
	public boolean isSessionValid(String token)
	{
		try
		{
			logger.info("METHOD EXECUTION START");
			
			@SuppressWarnings("unused")
			AuthResponse authResponse = authClient.getValidity(token);
		}
		catch (Exception e)
		{
			logger.info("METHOD EXECUTION END - AUTHORIZATION FAILED");
			
			return false;
		}
		logger.info("METHOD EXECUTION END - AUTHORIZATION SUCCESSFUL");
		
		return true;
	}
	
	public void addData()
	{
		logger.info("METHOD EXECUTION START");
		
		HospitalAddress hospitalAddress1 = new HospitalAddress(1, "Nandan Kanan", "Jora Bridge", "Kolkata", 700075, "West Bengal", "India");
		Hospital hospital1 = new Hospital(1, "Amri Hospital", 100, 987654321, "amrihospital@gmail.com");
		hospitalAddress1.setHospital(hospital1);
		hospital1.setHospitalAddress(hospitalAddress1);
		hospitalRepository.save(hospital1);
		
		
		HospitalAddress hospitalAddress2 = new HospitalAddress(2, "Garia", "Santoshpur", "Chennal", 600046, "Tamil Nadu", "India");
		Hospital hospital2 = new Hospital(2, "Peerless Hospital", 150, 123456789, "peerlesshospital@gmail.com");
		hospitalAddress2.setHospital(hospital2);
		hospital2.setHospitalAddress(hospitalAddress2);
		hospitalRepository.save(hospital2);
		
		HospitalAddress hospitalAddress3 = new HospitalAddress(3, "Behala", "Sealdah", "Shimla", 862001, "Himachal Pradesh", "India");
		Hospital hospital3 = new Hospital(3, "Amrital Hospital", 75, 44442222, "amritalhospital@gmail.com");
		hospitalAddress3.setHospital(hospital3);
		hospital3.setHospitalAddress(hospitalAddress3);
		hospitalRepository.save(hospital3);
		
		logger.info("METHOD EXECUTION END");
	}

}
