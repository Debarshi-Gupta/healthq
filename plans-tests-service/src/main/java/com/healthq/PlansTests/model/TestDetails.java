package com.healthq.PlansTests.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class TestDetails {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "test_name", nullable = false)
	private String testName;
	
	@Column(name = "test_description", nullable = true)
	private String description;
	
	@Column(name = "test_unit", nullable = false)
	private String unit;
	
	@Column(name = "test_range", nullable = false)
	private String range;
	
	@Column(name = "test_price", nullable = false)
	private int price;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "testDetails")
	private Set<PlanTestMapping> planTestMapping = new HashSet<>();

	public TestDetails() {
		super();
	}

	public TestDetails(String testName, String description, String unit, String range, int price) {
		super();
		this.testName = testName;
		this.description = description;
		this.unit = unit;
		this.range = range;
		this.price = price;
	}

	public TestDetails(int id, String testName, String description, String unit, String range, int price) {
		super();
		this.id = id;
		this.testName = testName;
		this.description = description;
		this.unit = unit;
		this.range = range;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Set<PlanTestMapping> getPlanTestMapping() {
		return planTestMapping;
	}

	public void setPlanTestMapping(Set<PlanTestMapping> planTestMapping) {
		this.planTestMapping = planTestMapping;
	}
	
	
	
	

}
