package com.dev.springdata.ps;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.dev.springdata.ps.daos.LaptopDao;
import com.dev.springdata.ps.entities.Laptop;
import com.dev.springdata.ps.repositories.LaptopRepository;

@SpringBootTest
class ApplicationTests {

	@Autowired
	LaptopDao laptopDao;

	@Autowired
	LaptopRepository lr;

	@Test
	void contextLoads() {
	}

	// mocked data
	public List<Laptop> generateLaptopValues() {
		List<Laptop> laptops = new ArrayList<>();
		laptops.add(new Laptop("dell", "inspiron", "x100", "pz5367125", 10, 15999.00));
		laptops.add(new Laptop("hp", "pavillon", "a100", "kipsiw25332125", 1, 14999.00));
		laptops.add(new Laptop("compaq", "hq", "c100", "ax5367125", 20, 17999.00));
		laptops.add(new Laptop("lenovo", "think pad", "x100", "psz53621125", 30, 34999.00));
		laptops.add(new Laptop("acer", "riot", "d100", "xpe5367125", 3, 12999.00));
		laptops.add(new Laptop("apple", "air", "ee099", "az5367125", 4, 12999.00));
		laptops.add(new Laptop("dell", "inspiron", "x200", "35367125", 33, 11999.00));
		laptops.add(new Laptop("dell", "inspiron", "x300", "1123z5367125", 2, 12999.00));
		laptops.add(new Laptop("dell", "inspiron", "x400", "wqez5367125", 4, 143999.00));
		laptops.add(new Laptop("acer", "riot", "c100", "rewr5367125", 0, 13999.00));
		laptops.add(new Laptop("msi", "gamerz", "z2100", "xcv5367125", 15, 15999.00));
		laptops.add(new Laptop("asus", "rogue", "i3100", "xcv367125", 11, 14999.00));

		return laptops;
	}

	// start of: CRUD methods tests -------
	@Test
	public void createLaptopTest() {
		// fail();
		generateLaptopValues().forEach((l) -> laptopDao.addLaptop(l)); // persist each laptop
		boolean createdAllLaptops = (generateLaptopValues().size() == 12); // crap unit test
		assertTrue(createdAllLaptops, "all 12 laptops created");
	}

	@Test
	public void readLaptopTest() {
		// fail();
		boolean result = laptopDao.getLaptop(2);
		assertTrue(result, "laptop found from db");
	}

	@Test
	public void updateLaptopTest() {
		// fail();
		int id = 3; // enter laptop id here
		boolean result = laptopDao.updateLaptop(1, "compaq", "hq", "x100", "pz5367125", 3, 14999.00);
		assertTrue(result, "laptop updated from db");
	}

	@Test
	public void deleteLaptopTest() {
		// fail();
		boolean result = laptopDao.deleteLaptop(5);
		assertTrue(result, "laptop deleted from db");
	}

	// end of: CRUD methods tests -------

	// start of: pagination & sorting methods tests -------

	@Test
	public void findAllwithPaginationTest() {
		// fail();

		// configure the Pageable using the PageRequest.of static class
		// params: pageNumber and numberOfResults to be displayed
		// paging starts at index 0
		Pageable pageable = PageRequest.of(0, 3);

		// store the results in a Page type
		Page<Laptop> results = lr.findAll(pageable);

		// iterate through the results
		// iterate via lambda and streams approach
		results.forEach((p) -> {
			System.out.println(p.getName() + " | " + p.getPrice());
		});

		// iterate via iterator approach
		/*
		 * Iterator<Laptop> it = results.iterator(); while(it.hasNext()) { Laptop l =
		 * it.next(); System.out.println(l.getName() + " | " + l.getPrice()); }
		 */
	}

	@Test
	public void findAllwithSortingByOneFieldTest() {
		// 2 things are important when sorting: from which property and the direction
		// here we sort by 1 field which is name
		lr.findAll(Sort.by(new Sort.Order(Direction.DESC, "name"))).forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void findAllwithSortingByMultipleFieldsAndDirectionsTest() {
		// 2 things are important when sorting: from which property and the direction
		// here we sort by 2 fields which is via name & multiple directions
		// if null is in the first param of Sort.Order args, it defaults to
		// Direction.ASC
		lr.findAll(Sort.by(new Sort.Order(null, "brand"), new Sort.Order(Direction.DESC, "name")))
				.forEach((p) -> System.out.println(p.getBrand() + " | " + p.getPrice()));
	}

	@Test
	public void findAllwithPaginationAndSorting() {
		// Doc: https://www.baeldung.com/spring-data-jpa-pagination-sorting
		Pageable pageable = PageRequest.of(0, 3, Sort.by("name").descending());

		Page<Laptop> results = lr.findAll(pageable);

		results.forEach(p -> System.out.println(p));
	}

	@Test
	public void findAllwithPaginationAndSortingViaCustomFinder() {
		// 1. in the repo interface, find a custom finder and add a Pageable parameter
		// at the end
		// 2. configure a Pageable property
		// 3. complete your code logic

		Pageable pageable = PageRequest.of(0, 10, Sort.by("name").descending());
		
		Page<Laptop> results = lr.findByPriceGreaterThan(16000.00, pageable);
		
		results.forEach(p -> System.out.println(p.getPrice() + " | " + p.getName()));
	}

}
