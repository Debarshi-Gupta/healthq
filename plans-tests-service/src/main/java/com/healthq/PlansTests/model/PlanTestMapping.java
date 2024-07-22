package com.healthq.PlansTests.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "plan_test_mapping")
public class PlanTestMapping {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "plan_id")
	private PlanDetails planDetails;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "test_id")
	private TestDetails testDetails;

	public PlanTestMapping() {
		super();
	}

	public PlanTestMapping(PlanDetails plan, TestDetails test) {
		super();
		this.planDetails = plan;
		this.testDetails = test;
	}

	public PlanTestMapping(int id, PlanDetails plan, TestDetails test) {
		super();
		this.id = id;
		this.planDetails = plan;
		this.testDetails = test;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PlanDetails getPlan() {
		return planDetails;
	}

	public void setPlan(PlanDetails plan) {
		this.planDetails = plan;
	}

	public TestDetails getTest() {
		return testDetails;
	}

	public void setTest(TestDetails test) {
		this.testDetails = test;
	}

}
