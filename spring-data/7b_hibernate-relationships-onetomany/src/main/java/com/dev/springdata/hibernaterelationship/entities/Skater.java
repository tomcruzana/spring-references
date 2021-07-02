package com.dev.springdata.hibernaterelationship.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Skater {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String fname;

	private String lname;

	private int age;

	/*
	 * We use one to many since there can only be one skater but can have many
	 * skateboards.
	 * 
	 * MappedBy signals hibernate that the key (PK) for the mapping is in this
	 * entity/table
	 * 
	 * cascade all means all crud functions will affect to the related table of this
	 * table.
	 */
	@OneToMany(mappedBy = "skater", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Skateboard> skateboards;

	// constructor to instantiate the skateboards Set
	public Skater() {
		this.skateboards = new HashSet<>();
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Skateboard> getSkateboards() {
		return skateboards;
	}

	// here we make a utility method for ease of adding skateboards
	public void addSkateboard(Skateboard skateboard) {
		this.skateboards.add(skateboard);
	}

	@Override
	public String toString() {
		return "Skater [id=" + id + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", skateboards="
				+ skateboards + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skater other = (Skater) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
