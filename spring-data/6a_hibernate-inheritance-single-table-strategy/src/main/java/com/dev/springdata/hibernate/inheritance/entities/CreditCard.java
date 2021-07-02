package com.dev.springdata.hibernate.inheritance.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*
 * this is the value the will be stored in the db column mapped.
 * this also applies to the check entity
 * @DiscriminatorValue(value = "cc")
 * */

@Entity
@DiscriminatorValue(value = "cc")
public class CreditCard extends Payment {
	
	@Column(name="creditcardnumber")
	private String creditCardNumber;

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	
}
