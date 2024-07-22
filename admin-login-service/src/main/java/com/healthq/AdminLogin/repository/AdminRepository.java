package com.healthq.AdminLogin.repository;

import com.healthq.AdminLogin.model.AdminDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminDetails, Integer> {
	
	public AdminDetails findById(int id);
	
	public AdminDetails findByUsername(String username);

}
