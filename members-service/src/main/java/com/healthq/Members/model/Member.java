package com.healthq.Members.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "member")
public class Member {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "gender", nullable = false)
	private String gender;
	
	@Column(columnDefinition = "DATE", name = "dob", nullable = false)
	private LocalDate dob;
	
	@Column(columnDefinition = "INTEGER", name = "contact_number", nullable = false, unique = true)
	private long contactNumber;
	
	@Column(name = "email_id", nullable = false)
	private String emailId;
	
	@Column(name = "plan_id", nullable = false)
	private int planId;
	
	@Column(name = "plan_cost", nullable = false)
	private int planCost;
	
	@Column(columnDefinition = "TIMESTAMP", name = "appointment_date", nullable = false)
	private LocalDateTime appointmentDate;
	
	@Column(name = "hospital_id", nullable = false)
	private int hospitalId;

	public Member() {
		super();
	}

	public Member(String address, String name, String gender, LocalDate dob, long contactNumber, String emailId,
			int planId, int planCost, LocalDateTime appointmentDate, int hospitalId) {
		super();
		this.address = address;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.planId = planId;
		this.planCost = planCost;
		this.appointmentDate = appointmentDate;
		this.hospitalId = hospitalId;
	}

	public Member(int id, String address, String name, String gender, LocalDate dob, long contactNumber, String emailId,
			int planId, int planCost, LocalDateTime appointmentDate, int hospitalId) {
		super();
		this.id = id;
		this.address = address;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.planId = planId;
		this.planCost = planCost;
		this.appointmentDate = appointmentDate;
		this.hospitalId = hospitalId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
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

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public int getPlanCost() {
		return planCost;
	}

	public void setPlanCost(int planCost) {
		this.planCost = planCost;
	}

	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDateTime appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	
	
	

}
