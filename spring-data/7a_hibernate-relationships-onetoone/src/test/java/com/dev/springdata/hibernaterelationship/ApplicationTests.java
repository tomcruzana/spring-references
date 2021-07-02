package com.dev.springdata.hibernaterelationship;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.dev.springdata.hibernaterelationship.entities.License;
import com.dev.springdata.hibernaterelationship.entities.Person;
import com.dev.springdata.hibernaterelationship.repository.LicenseRepo;

@SpringBootTest
class ApplicationTests {

	@Autowired
	LicenseRepo lr;

	@Test
	void contextLoads() {
	}

	// create
	@Test
	public void createLicenseWithPersonTest() {
		// fail();

		// create the license first
		License license = new License();
		license.setLicenseNumber(5367125);

		// create the person second
		Person person = new Person();
		person.setFirstName("anthony");
		person.setLastName("romney");
		person.setAge(30);

		// assign or associate the person to the license
		license.setPerson(person);

		// persist the data
		lr.save(license);
	}

	// read
	@Test
	public void readLicenseWithPersonTest() {
		// fail();
		List<Object[]> li = lr.findLicenseById(5367125);

		// since the table license has 2 columns, we access index 0 & 2
		li.forEach(l -> System.out.println(l[0] + " " + l[1]));
	}

	// update
	@Transactional
	@Rollback(value = false)
	@Test
	public void updateLicenseWithPersonTest() {
		// fail();
		lr.updateLicenseById(1117770,5367125);
	}

	// delete
	@Test
	public void deleteCascadeLicenseTest() {
		// fail();
		lr.deleteById(123456789);
	}

}
