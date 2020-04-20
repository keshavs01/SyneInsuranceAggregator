package com.synechron.insurancecompany.entity;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.synechron.insurancecompany.utils.DateDeSerializer;

@Table(name="policy")
public class Policy {
	
	@Id
	@NotNull
	@NotBlank(message = "Policy ID is mandatory")
	private String id;
	
	@Length(max = 30, message = "Maximum length of name allowed is 30 characters")
	@NotBlank(message = "Policy name is mandatory")
	private String name;
	
	@Length(min = 10, max = 250, message = "Maximum length of description allowed is 250 characters")
	private String description;
	
	@JsonDeserialize(using = DateDeSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date validFrom;
	
	@JsonDeserialize(using = DateDeSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date validTo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public Date getValidTo() {
		return validTo;
	}
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	@Override
	public String toString() {
		return "Policy [id=" + id + ", name=" + name + ", description=" + description + ", validFrom=" + validFrom
				+ ", validTo=" + validTo + "]";
	}

}
