package com.dev.springdata.hibernateinheritance.entity;

import javax.persistence.Entity;

@Entity
public class Developer extends Person {
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
