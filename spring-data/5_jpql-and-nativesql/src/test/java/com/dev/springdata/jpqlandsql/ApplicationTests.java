package com.dev.springdata.jpqlandsql;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.dev.springdata.jpqlandsql.entities.Customer;
import com.dev.springdata.jpqlandsql.repositories.CustomerRepository;

@SpringBootTest
class ApplicationTests {

	@Autowired
	CustomerRepository custRepo;

	@Test
	void contextLoads() {
	}

	// ------------------------CRUD tests
	@Test
	public void createCustomersTest() {
		// fail();
		Customer cx = new Customer("Sammy", "Rolex", 48.751911, -122.478683);
		custRepo.save(cx);
	}

	// ------------------------JPQL tests
	@Test
	public void findAllCustomersTest() {
		// fail();
		List<Customer> cxs = custRepo.findAllCustomers();
		cxs.forEach(cx -> System.out.println(cx));
	}

	@Test
	public void findCustomersPartialDataTest() {
		// fail();
		List<Object[]> cxs = custRepo.findCustomersByNameAndCoords();
		cxs.forEach(cx -> {
			// the indexes represents the columns in the query
			System.out.println(cx[0] + " " + cx[1] + " " + cx[2]);
		});
	}

	@Test
	public void findByCustomerLastName() {
		// fail();
		List<Customer> cxs = custRepo.findByCustomerLastName("maze");
		cxs.forEach(cx -> System.out.println(cx));
	}

	@Test
	public void findByCustomerMultipleParamsTest() {
		// fail();
		List<Customer> cxs = custRepo.findByCustomerWithMinMaxIds(3, 5);
		cxs.forEach(cx -> System.out.println(cx));
	}

	// import transactional from springframework package.
	// see repo interface for notes
	// @Rollback is exclusive for junit test
	// since the default behavior of a test does not to apply to the transaction
	@Test
	@Transactional
	@Rollback(false)
	public void deleteCustomerTest() {
		// fail();
		custRepo.deleteCustomer(6);
		System.out.println("customer deleted. check you db.");
	}

	// pagination & sorting
	@Test
	public void findAndPaginateTest() {
		// fail();

		// sort is an optional param
		List<Object[]> cxs = custRepo.findCustomerByIdLatLong(PageRequest.of(0, 3, Sort.by("id").descending()));

		// traverse the result set
		cxs.forEach(cx -> {
			// the indexes represents the columns in the query
			System.out.println(cx[0] + " " + cx[1] + " " + cx[2]);
		});
	}

	// NATIVE SQL TESTS
	@Test
	public void findByNativeSqlColumnsTest() {
		// fail();
		List<Object[]> cxs = custRepo.findByNativeSqlColumns();

		// traverse the result set
		cxs.forEach(cx -> {
			// the indexes represents the columns in the query
			System.out.println(cx[0] + " " + cx[1] + " " + cx[2]);
		});
	}
	
	@Test
	public void findByNativeSqlWithParamsTest() {
		// fail();
		List<Customer> cxs = custRepo.findByNativeSqlWithParams(2);
		cxs.forEach(cx -> System.out.println(cx));
	}
}
