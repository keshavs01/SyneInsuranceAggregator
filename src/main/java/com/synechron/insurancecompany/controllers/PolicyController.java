package com.synechron.insurancecompany.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.insurancecompany.entity.Policy;
import com.synechron.insurancecompany.services.PolicyService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1")
public class PolicyController {

	@Autowired
	private PolicyService service;

	@GetMapping(path = "/policy", produces="application/json")
	public List<Policy> getPloicy() {
		return service.getPolicy();
	}

	@GetMapping(path = "/policy/{policyId}", produces="application/json")
	public Policy getPloicyFromId(@PathVariable("policyId") String policyId){
		return service.getPolicyById(policyId);
	}

	@PostMapping(path = "/addupdatepolicy", produces="application/json", consumes = "application/json")
	public Policy addUpdatePloicy(@Valid @RequestBody Policy policy) {
		
		return service.addUpdatePolicy(policy);
	}

	@PutMapping(path = "/addupdatepolicy", produces="application/json", consumes = "application/json")
	public Policy updatePloicy(@Valid @RequestBody Policy policy) {
		return service.addUpdatePolicy(policy);
	}

	@DeleteMapping(path = "/deletepolicy/{policyId}",produces = "application/json")
	public Policy deletePloicy(@PathVariable("policyId") String policyId) {
		return service.deletePolicy(policyId);
	}	
}
