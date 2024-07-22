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
@Table(name = "plan")
public class PlanDetails {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "plan_name", nullable = false, unique = true)
	private String planName;
	
	@Column(name = "plan_description", nullable = true)
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "planDetails")
	private Set<PlanTestMapping> planTestMapping = new HashSet<>();

	public PlanDetails() {
		super();
	}

	public PlanDetails(String planName, String description) {
		super();
		this.planName = planName;
		this.description = description;
	}

	public PlanDetails(int id, String planName, String description) {
		super();
		this.id = id;
		this.planName = planName;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<PlanTestMapping> getPlanTestMapping() {
		return planTestMapping;
	}

	public void setPlanTestMapping(Set<PlanTestMapping> planTestMapping) {
		this.planTestMapping = planTestMapping;
	}
	
	

}
