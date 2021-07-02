package com.dev.springdata.hibernate.inheritance.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*
 * key notes:
 * 
 * this is the strategy
 * @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
 * 
 * the pmode is present in the mysql db
 * you dont create this property/column in the entity class,
 * hence you configure it via this annotation
 * @DiscriminatorColumn(name = "pmode", discriminatorType = DiscriminatorType.STRING)
 * 
 * */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pmode", discriminatorType = DiscriminatorType.STRING)
public abstract class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private double amount;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
