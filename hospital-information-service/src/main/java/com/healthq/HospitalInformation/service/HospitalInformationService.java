package com.healthq.HospitalInformation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthq.HospitalInformation.model.Hospital;
import com.healthq.HospitalInformation.model.HospitalAddress;
import com.healthq.HospitalInformation.model.HospitalMap;

@Service
public interface HospitalInformationService {
	
	public List<HospitalMap> getAllHospitalInformation();
	
	public void addHospitalInformation(Hospital hospital, HospitalAddress hospitalAddress);
	
	public void changeHospitalInformation(Hospital hospital, HospitalAddress hospitalAddress);
	
	public void removeHospitalInformation(Hospital hospital, HospitalAddress hospitalAddress);
	
	public boolean isSessionValid(String token);
	
	public void addData();

}
