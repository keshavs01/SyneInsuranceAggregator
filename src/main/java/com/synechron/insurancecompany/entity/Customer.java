package com.synechron.insurancecompany.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name="customer")
@AllArgsConstructor
public class Customer {
	
	@Id 
	private String Id;
	
	private String fname;
	private String lname;
	private String address;
	

}
