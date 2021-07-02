package com.dev.springdata.hibernaterelationship.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Salesman {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String fname;

	private String lname;

	private int salesCount;

	/*
	 * cascade all - all crud functions affect related table
	 * 
	 * jointable is assigned to the junction table named orders
	 * 
	 * join column, is basically formatted like the reference key declaration in the
	 * orders table. important! the @joinColumn order matters! in this case the
	 * mapper is the Salesman entity, hence the salesman_id goes first
	 * 
	 * inverseJoinColumns is simply the other table
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "orders", joinColumns = @JoinColumn(name = "salesman_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"))
	private Set<Customer> customers;

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

	public int getSalesCount() {
		return salesCount;
	}

	public void setSalesCount(int salesCount) {
		this.salesCount = salesCount;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Salesman [id=" + id + ", fname=" + fname + ", lname=" + lname + ", salesCount=" + salesCount
				+ ", customers=" + customers + "]";
	}

}
