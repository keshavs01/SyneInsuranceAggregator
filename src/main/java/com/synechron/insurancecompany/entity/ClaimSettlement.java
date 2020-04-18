package com.synechron.insurancecompany.entity;

import javax.persistence.Id;

//@Entity
public class ClaimSettlement {
	
	@Id
	String settlementId;
	String policyId;
	String customerId;
	String paymentId;
	

}
