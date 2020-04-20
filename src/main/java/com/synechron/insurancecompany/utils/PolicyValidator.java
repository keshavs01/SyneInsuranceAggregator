package com.synechron.insurancecompany.utils;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.synechron.insurancecompany.entity.Policy;

@Component
public class PolicyValidator {

	public boolean isValidDates(Policy policy) {
		Date fromDate = policy.getValidFrom();
		Date toDate = policy.getValidTo();
		if(fromDate.after(toDate)) {
			return false;			
		}
		return true;		
	}
}
