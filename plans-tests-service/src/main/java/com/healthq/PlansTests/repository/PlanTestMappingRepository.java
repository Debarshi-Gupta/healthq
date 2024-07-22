package com.healthq.PlansTests.repository;

import com.healthq.PlansTests.model.PlanTestMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanTestMappingRepository extends JpaRepository<PlanTestMapping, Integer> {

}
