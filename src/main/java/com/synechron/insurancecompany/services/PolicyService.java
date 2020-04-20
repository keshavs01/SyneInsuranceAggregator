package com.synechron.insurancecompany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechron.insurancecompany.entity.Policy;
import com.synechron.insurancecompany.exceptions.CustomException;
import com.synechron.insurancecompany.repos.PolicyRepository;
import com.synechron.insurancecompany.utils.PolicyValidator;

@Service
public class PolicyService {

	@Autowired
	private PolicyRepository repo;
	
	@Autowired
	private PolicyValidator validator;

	public List<Policy> getPolicy() throws CustomException {
		if (repo.findAll().size() > 0) {
			return repo.findAll();
		} else {
			throw new CustomException("No records found in database");
		}
	}
	
	public Policy getPolicyById(String policyId) throws CustomException {
		Optional<Policy> policy = repo.findById(policyId);
		if(policy.isPresent()) {
			return policy.get();
		} else {
			throw new CustomException("Policy ID not found in database");
		}
	}

	public Policy addUpdatePolicy(Policy policy) throws CustomException {
		if (policy.getId() != null) {
			if(validator.isValidDates(policy)) {
				repo.save(policy);
			} else {
				throw new CustomException("Policy validFrom date is greater than validTo date");
			}			
		} else {
			throw new CustomException("Policy ID is null");
		}
		return policy;
	}

	public Policy deletePolicy(String policyId) throws CustomException {
		Optional<Policy> pc = repo.findById(policyId);
		if (!pc.isPresent()) {
			throw new CustomException("Policy not present in database");
		} else {
			repo.deleteById(policyId);
			return pc.get();
		}
	}

}
