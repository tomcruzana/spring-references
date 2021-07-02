package com.dev.springdata.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dev.springdata.product.entities.Product;
import com.dev.springdata.product.repositories.ProductRepository;

@SpringBootTest
class ProductdataApplicationCrudTests {

	@Autowired
	ProductRepository repo;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(4);
		product.setName("Andoird");
		product.setDesc("shit phone");
		product.setPrice(999.00);

		product = repo.save(product);
	}

	@Test
	public void testRead() {
		Product product = repo.findById(1).get();
		assertNotNull(product);
		assertEquals("iPhone", product.getName());
		System.out.println(product.getName());
	}

	@Test
	public void testUpdate() {
		Product product = repo.findById(1).get();
		product.setPrice(799.00);
		// hibernate will auto check if it needs to insert or update the database
		product = repo.save(product);
	}

	@Test
	public void testDelete() {

		// optional validation
		if (repo.existsById(5)) {
			System.out.println("Deleting the product.");

			// actual delete method
			repo.deleteById(5);
		}

	}
	
	@Test
	public void testCountRows() {
		// counts rows/records of the db
		System.out.println(repo.count() + " : total rows found in the db!");
	}

}
