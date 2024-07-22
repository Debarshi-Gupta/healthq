package com.healthq.Members.model;

public class MemberDTO {
	
	private int id;
	
	private String address;
	
	private String name;
	
	private String gender;
	
	private int dobDay;
	
	private int dobMonth;
	
	private int dobYear;
	
	private long contactNumber;
	
	private String emailId;
	
	private int planId;
	
	private int planCost;
	
	private int appointmentDateDay;
	
	private int appointmentDateMonth;
	
	private int appointmentDateYear;
	
	private int appointmentDateHour;
	
	private int hospitalId;

	public MemberDTO() {
		super();
	}

	public MemberDTO(String address, String name, String gender, int dobDay, int dobMonth, int dobYear,
			long contactNumber, String emailId, int planId, int planCost, int appointmentDateDay,
			int appointmentDateMonth, int appointmentDateYear, int appointmentDateHour, int hospitalId) {
		super();
		this.address = address;
		this.name = name;
		this.gender = gender;
		this.dobDay = dobDay;
		this.dobMonth = dobMonth;
		this.dobYear = dobYear;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.planId = planId;
		this.planCost = planCost;
		this.appointmentDateDay = appointmentDateDay;
		this.appointmentDateMonth = appointmentDateMonth;
		this.appointmentDateYear = appointmentDateYear;
		this.appointmentDateHour = appointmentDateHour;
		this.hospitalId = hospitalId;
	}

	public MemberDTO(int id, String address, String name, String gender, int dobDay, int dobMonth, int dobYear,
			long contactNumber, String emailId, int planId, int planCost, int appointmentDateDay,
			int appointmentDateMonth, int appointmentDateYear, int appointmentDateHour, int hospitalId) {
		super();
		this.id = id;
		this.address = address;
		this.name = name;
		this.gender = gender;
		this.dobDay = dobDay;
		this.dobMonth = dobMonth;
		this.dobYear = dobYear;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.planId = planId;
		this.planCost = planCost;
		this.appointmentDateDay = appointmentDateDay;
		this.appointmentDateMonth = appointmentDateMonth;
		this.appointmentDateYear = appointmentDateYear;
		this.appointmentDateHour = appointmentDateHour;
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
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getDobDay() {
		return dobDay;
	}

	public void setDobDay(int dobDay) {
		this.dobDay = dobDay;
	}

	public int getDobMonth() {
		return dobMonth;
	}

	public void setDobMonth(int dobMonth) {
		this.dobMonth = dobMonth;
	}

	public int getDobYear() {
		return dobYear;
	}

	public void setDobYear(int dobYear) {
		this.dobYear = dobYear;
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

	public int getAppointmentDateDay() {
		return appointmentDateDay;
	}

	public void setAppointmentDateDay(int appointmentDateDay) {
		this.appointmentDateDay = appointmentDateDay;
	}

	public int getAppointmentDateMonth() {
		return appointmentDateMonth;
	}

	public void setAppointmentDateMonth(int appointmentDateMonth) {
		this.appointmentDateMonth = appointmentDateMonth;
	}

	public int getAppointmentDateYear() {
		return appointmentDateYear;
	}

	public void setAppointmentDateYear(int appointmentDateYear) {
		this.appointmentDateYear = appointmentDateYear;
	}

	public int getAppointmentDateHour() {
		return appointmentDateHour;
	}

	public void setAppointmentDateHour(int appointmentDateHour) {
		this.appointmentDateHour = appointmentDateHour;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

}
