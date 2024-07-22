package com.healthq.PlansTests.repository;

import com.healthq.PlansTests.model.PlanDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanDetailsRepository extends JpaRepository<PlanDetails, Integer> {

}
