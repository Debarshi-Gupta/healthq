package com.healthq.PlansTests.model;

import java.util.ArrayList;
import java.util.List;

public class PlanTestWrapperObject {
	
	private PlanDetails plan;
	
	private List<TestDetails> testList = new ArrayList<>();

	public PlanTestWrapperObject() {
		super();
	}

	public PlanTestWrapperObject(PlanDetails plan, List<TestDetails> testList) {
		super();
		this.plan = plan;
		this.testList = testList;
	}

	public PlanDetails getPlan() {
		return plan;
	}

	public void setPlan(PlanDetails plan) {
		this.plan = plan;
	}

	public List<TestDetails> getTestList() {
		return testList;
	}

	public void setTestList(List<TestDetails> testList) {
		this.testList = testList;
	}
	
	

}
