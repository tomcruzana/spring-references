package com.dev.springdata.hibernaterelationship;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.dev.springdata.hibernaterelationship.entities.Customer;
import com.dev.springdata.hibernaterelationship.entities.Salesman;
import com.dev.springdata.hibernaterelationship.repo.SalesmanRepo;

@SpringBootTest
class ApplicationTests {

	@Autowired
	SalesmanRepo sr;

	@Test
	void contextLoads() {
	}

	@Test
	public void createSalesmanAndCustomerOrderSample() {

		// fail();

		// create customer list
		Customer customer1 = new Customer();
		customer1.setFname("ramon");
		customer1.setLname("rogue");

		Customer customer2 = new Customer();
		customer2.setFname("isaac");
		customer2.setLname("kukuri");

		Set<Customer> customerSet = new HashSet<>();
		customerSet.add(customer1);
		customerSet.add(customer2);

		// create salesmen
		Salesman salesman = new Salesman();
		salesman.setFname("maverick");
		salesman.setLname("maze");
		salesman.setSalesCount(2);
		salesman.setCustomers(customerSet);

		// assign a salesman to the customer
		Set<Salesman> salesmenSet = new HashSet<>();
		salesmenSet.add(salesman);
		customer1.setSalesman(salesmenSet);
		customer2.setSalesman(salesmenSet);

		// persist data
		sr.save(salesman);
	}

	// read
	// here we decorate it with @Transactional so it wont throw an error when LAZY
	// fetching
	@Transactional
	@Test
	public void readSalesmanTest() {
		// fail();
		List<Salesman> salesman = sr.findById(6);
		salesman.forEach(s -> System.out.println(s));
	}

	// update
	@Transactional
	@Rollback(false)
	@Test
	public void updateSalesmanTest() {
		// fail();
		List<Salesman> salesman = sr.findById(6);
		salesman.forEach(s -> s.setLname("maaz"));
	}

	// delete
	@Test
	public void deleteSalesmanTest() {
		// fail();
		sr.deleteById(6);
		
	}
}
