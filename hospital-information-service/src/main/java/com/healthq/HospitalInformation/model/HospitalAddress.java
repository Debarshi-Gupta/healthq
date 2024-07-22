package com.healthq.HospitalInformation.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hospitaladdress")
public class HospitalAddress {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "street_line_1", nullable = false)
	private String streetLine1;
	
	@Column(name = "street_line_2", nullable = true)
	private String streetLine2;
	
	@Column(name = "location", nullable = false)
	private String location;
	
	@Column(name = "pincode", nullable = false)
	private int pincode;
	
	@Column(name = "state", nullable = false)
	private String state;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "hospitalAddress")
	private Hospital hospital;

	public HospitalAddress(int id, String streetLine1, String streetLine2, String location, int pincode, String state,
			String country) {
		super();
		this.id = id;
		this.streetLine1 = streetLine1;
		this.streetLine2 = streetLine2;
		this.location = location;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
	}

	public HospitalAddress() {
		super();
	}

	public HospitalAddress(String streetLine1, String streetLine2, String location, int pincode, String state,
			String country) {
		super();
		this.streetLine1 = streetLine1;
		this.streetLine2 = streetLine2;
		this.location = location;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetLine1() {
		return streetLine1;
	}

	public void setStreetLine1(String streetLine1) {
		this.streetLine1 = streetLine1;
	}

	public String getStreetLine2() {
		return streetLine2;
	}

	public void setStreetLine2(String streetLine2) {
		this.streetLine2 = streetLine2;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	
	

}
