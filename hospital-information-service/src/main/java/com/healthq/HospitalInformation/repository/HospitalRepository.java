package com.healthq.HospitalInformation.repository;

import com.healthq.HospitalInformation.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
	


}
