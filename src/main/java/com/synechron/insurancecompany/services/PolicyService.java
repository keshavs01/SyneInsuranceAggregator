package com.synechron.insurancecompany.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechron.insurancecompany.entity.Policy;
import com.synechron.insurancecompany.repos.PolicyRepository;

@Service
public class PolicyService {

	@Autowired
	private PolicyRepository repo;

	public List<Policy> getPolicy() {
		return repo.findAll();
	}
	
	public Policy getPolicyById(String policyId) throws Exception {
		Optional<Policy> policy = repo.findById(policyId);
		if(policy.isPresent()) {
			return policy.get();
		} else {
			throw new Exception("Policy ID not found in database");
		}
	}

	public Policy addUpdatePolicy(Policy policy) throws Exception {
				
		if (policy.getId() != null) {
			if(policy.getValidFrom().after(policy.getValidTo())) {
				throw new Exception("Policy from date can not be greater than Policy to date");
			} else if (policy.getDescription().length() > 250) {
				throw new Exception("Description length cannot be more than 250 charecters");
			}
			repo.save(policy);
		} else {
			throw new Exception("Policy ID is null");
		}
		return policy;
	}

	public Policy deletePolicy(String policyId) throws Exception {
		Optional<Policy> pc = repo.findById(policyId);
		if (!pc.isPresent()) {
			throw new Exception("Policy not present in database");
		} else {
			repo.deleteById(policyId);
			return pc.get();
		}

	}

}
