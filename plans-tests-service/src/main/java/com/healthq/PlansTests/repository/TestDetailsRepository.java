package com.healthq.PlansTests.repository;

import com.healthq.PlansTests.model.TestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDetailsRepository extends JpaRepository<TestDetails, Integer> {
	
	public TestDetails findById(int id);

}
