package com.dev.springdata.hibernaterelationship.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class License {

	// here we dont use an id generation strategy since it's not set to auto
	// increment in the db
	@Id
	private int licenseNumber;

	/*
	 * here declare a person entity obj. this will be used for bidirectional rel
	 * 
	 * we set it to @OneToOne
	 * 
	 * cascade is set to all to reflect all the crud changes in the db.
	 * 
	 * the @JoinColumn indicates the FK of the person PK in the its db table (License table)
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "person_id")
	private Person person;

	public int getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(int licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "License [licenseNumber=" + licenseNumber + ", person=" + person + "]";
	}

}
