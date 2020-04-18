package com.synechron.insurancecompany.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synechron.insurancecompany.entity.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, String> {
	

}
