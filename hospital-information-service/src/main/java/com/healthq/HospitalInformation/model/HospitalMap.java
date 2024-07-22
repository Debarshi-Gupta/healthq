package com.healthq.HospitalInformation.model;

public class HospitalMap {
	
	private Hospital hospital;
	
	private HospitalAddress hospitalAddress;

	public HospitalMap() {
	}

	public HospitalMap(Hospital hospital, HospitalAddress hospitalAddress) {
		this.hospital = hospital;
		this.hospitalAddress = hospitalAddress;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public HospitalAddress getHospitalAddress() {
		return hospitalAddress;
	}

	public void setHospitalAddress(HospitalAddress hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}
	
	
	
	

}
