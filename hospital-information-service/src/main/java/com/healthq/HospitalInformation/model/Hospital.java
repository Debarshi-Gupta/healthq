package com.healthq.HospitalInformation.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hospital")
public class Hospital {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(fetch = FetchType.LAZY, cascade  = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private HospitalAddress hospitalAddress;
	
	@Column(name = "hospital_name", nullable = false)
	private String hospitalName;
	
	@Column(name = "appointments_per_day", nullable = false)
	private int appointmentsPerDay;
	
	@Column(columnDefinition = "INTEGER", name = "contact_number", nullable = false, unique = true)
	private long contactNumber;
	
	@Column(name = "email_id", nullable = true)
	private String emailId;
	

	public Hospital() {
		super();
	}
	
	public Hospital(int id, String hospitalName, int appointmentsPerDay, long contactNumber, String emailId) {
		super();
		this.id = id;
		this.hospitalName = hospitalName;
		this.appointmentsPerDay = appointmentsPerDay;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
	}

	public Hospital(String hospitalName, int appointmentsPerDay, long contactNumber,
			String emailId) {
		super();
		this.hospitalName = hospitalName;
		this.appointmentsPerDay = appointmentsPerDay;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public HospitalAddress getHospitalAddress() {
		return hospitalAddress;
	}


	public void setHospitalAddress(HospitalAddress hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public int getAppointmentsPerDay() {
		return appointmentsPerDay;
	}

	public void setAppointmentsPerDay(int appointmentsPerDay) {
		this.appointmentsPerDay = appointmentsPerDay;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	

}
