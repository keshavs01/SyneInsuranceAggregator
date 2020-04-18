package com.synechron.insurancecompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="payment")
public class Payment {
	
	@Id
	@Column(name = "paymentid")
	private int paymentId;
	
	private double amount;
	private double discount;


}
