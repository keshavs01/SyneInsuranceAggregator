package com.synechron.insurancecompany.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.insurancecompany.entity.Policy;
import com.synechron.insurancecompany.services.PolicyService;

@RestController
@CrossOrigin(origins = "*")
public class PolicyController {

	@Autowired
	private PolicyService service;

	@GetMapping("api/v1/policy")
	public List<Policy> getPloicy() throws Exception {
		if(service.getPolicy().size() > 0) {
			return service.getPolicy();
		} else {
			throw new Exception("No record present in database");
		}		
	}
	
	@GetMapping("api/v1/policy/{policyId}")
	public Policy getPloicyFromId(@PathVariable("policyId") String policyId) throws Exception {
		return service.getPolicyById(policyId);		
	}

	@PostMapping("api/v1/addupdatepolicy")
	public Policy addUpdatePloicy(@RequestBody Policy policy) throws Exception {
		return service.addUpdatePolicy(policy);		
	}

	@PutMapping("api/v1/addupdatepolicy")
	public Policy updatePloicy(@RequestBody Policy policy) throws Exception {
		return service.addUpdatePolicy(policy);
	}

	@DeleteMapping("api/v1/deletepolicy/{policyId}")
	public Policy deletePloicy(@PathVariable("policyId") String policyId) throws Exception {
		return service.deletePolicy(policyId);
	}

}
