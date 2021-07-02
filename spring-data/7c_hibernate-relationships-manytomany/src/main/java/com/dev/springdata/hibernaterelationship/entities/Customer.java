package com.dev.springdata.hibernaterelationship.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String fname;

	private String lname;

	// yeah i know this is confusing, customers is the name of the Set customers
	// type on the other table
	// this means, this shit the config is defined on the other table/entity

	/*
	 * Q&A: for many to many relationship mapping: so the mappedBy argument value
	 * must be name of the variable defined in other class?
	 * 
	 * That is correct it is the variable name in the class.mappedBy indicates that
	 * the entity in this side is the inverse of the relationship, and the owner
	 * resides in the "other" entity.
	 */
	@ManyToMany(mappedBy = "customers")
	private Set<Salesman> salesman;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Set<Salesman> getSalesman() {
		return salesman;
	}

	public void setSalesman(Set<Salesman> salesman) {
		this.salesman = salesman;
	}

}
