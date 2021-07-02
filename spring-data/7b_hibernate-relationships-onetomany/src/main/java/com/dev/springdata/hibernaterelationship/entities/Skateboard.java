package com.dev.springdata.hibernaterelationship.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Skateboard {
	@Id
	private int id;

	private String brand;

	/*
	 * Here we flip the relationship. There can be many skateboards that a skate can
	 * have.
	 * 
	 * joincolumn indicates the name of the FK in this entity's
	 * corresponding table.
	 */
	@ManyToOne
	@JoinColumn(name = "skater_id")
	private Skater skater;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Skater getSkater() {
		return skater;
	}

	public void setSkater(Skater skater) {
		this.skater = skater;
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
		Skateboard other = (Skateboard) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
