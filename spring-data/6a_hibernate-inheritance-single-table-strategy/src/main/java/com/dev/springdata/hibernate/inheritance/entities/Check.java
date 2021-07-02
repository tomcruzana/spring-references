package com.dev.springdata.hibernate.inheritance.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ch")
public class Check extends Payment {
	
	@Column(name="checknumber")
	private String checkNumber;

	public String getCreditCardNumber() {
		return checkNumber;
	}

	public void setCreditCardNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}
	
	
}
