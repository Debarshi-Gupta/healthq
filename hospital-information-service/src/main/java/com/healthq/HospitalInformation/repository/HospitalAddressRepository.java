package com.healthq.HospitalInformation.repository;

import com.healthq.HospitalInformation.model.HospitalAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalAddressRepository extends JpaRepository<HospitalAddress, Integer> {
	


}
