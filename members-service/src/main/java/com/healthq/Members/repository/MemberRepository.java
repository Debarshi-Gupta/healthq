package com.healthq.Members.repository;

import com.healthq.Members.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{
	
	@Query("select m from Member m where lower(m.name) = lower(:name) and m.contactNumber = :contactNumber")
	public Member findByNameContactNumber(@Param("name") String name, @Param("contactNumber") long contactNumber);

}
