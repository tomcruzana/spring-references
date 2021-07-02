package com.dev.springdata.idgenerators.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * notes:
 * 
 * -if you're manually creating the id in the code, you may use the @Id annotation only. no generation type needed.
 * @Id
 * 
 * -if sql is handling the pk using auto_increment for example, you need to specify IDENTITY in the generation strategy
 * @Id
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * 
 * -if you have to generate your own ids, use @TableGenerator(...). check section 6 - 44 in udemy 
 *  
 * */

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
