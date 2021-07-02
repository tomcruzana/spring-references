package com.dev.springdata.hibernateinheritance.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// is the only annotation you need to map all the class with is-a/inheritance relationship
//
// important! set @GeneratedValue(strategy = GenerationType.TABLE)
// if primary_key is set to auto_increment and you have to create a table id generation
// read explanation here: https://bit.ly/356Sr2n

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
	@Id
	private int id;
	private String fname;
	private String lname;

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

}
