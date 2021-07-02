package com.dev.springdata.hibernaterelationship;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.dev.springdata.hibernaterelationship.entities.Skateboard;
import com.dev.springdata.hibernaterelationship.entities.Skater;
import com.dev.springdata.hibernaterelationship.repository.SkaterRepo;

@SpringBootTest
class ApplicationTests {

	@Autowired
	SkaterRepo sr;

	@Test
	void contextLoads() {
	}

	// create
	@Test
	public void createSkaterTest() {
		// fail();

		// create skater
		Skater skater = new Skater();
		skater.setFname("ricardo");
		skater.setLname("zamora");
		skater.setAge(32);

		// create skateboards
		Skateboard skateboard1 = new Skateboard();
		skateboard1.setId(600);
		skateboard1.setBrand("hook ups");

		Skateboard skateboard2 = new Skateboard();
		skateboard2.setId(700);
		skateboard2.setBrand("april");

		// add/assign skateboards to skater (many-to-one)
		skater.addSkateboard(skateboard1);
		skater.addSkateboard(skateboard2);

		// add/assign the skater to skateboards (one-to-many)
		skateboard1.setSkater(skater);
		skateboard2.setSkater(skater);

		// save the transaction
		sr.save(skater);
	}

	// read
	// note if marked Transactional, Lazy loading would work and not shot an
	// exception
	@Test
	public void readSkaterTest() {
		// fail();
		List<Skater> skater = sr.findById(1);
		skater.forEach(s -> System.out.println(s + " " + s.getSkateboards()));

	}

	// update
	@Transactional
	@Rollback(value = false)
	@Test
	public void updateSkaterTest() {
		// fail();
		List<Skater> skater = sr.findById(1);
		skater.forEach(s -> s.setFname("jay"));
		sr.saveAll(skater);

	}

	// delete
	@Transactional
	@Rollback(value = false)
	@Test
	public void deleteSkaterTest() {
		// fail();
		List<Skater> skater = sr.findById(1);
		
		sr.delete(skater.get(0));

	}
}
