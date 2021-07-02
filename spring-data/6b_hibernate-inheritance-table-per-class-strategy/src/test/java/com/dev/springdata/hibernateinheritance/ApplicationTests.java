package com.dev.springdata.hibernateinheritance;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dev.springdata.hibernateinheritance.entity.Developer;
import com.dev.springdata.hibernateinheritance.entity.Humanoid;
import com.dev.springdata.hibernateinheritance.repo.PersonRepository;



@SpringBootTest
class ApplicationTests {

	@Autowired
	PersonRepository pr;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void createPersonDeveloperTest() {
		// fail();
		Developer dev = new Developer();
		dev.setId(1);
		dev.setFname("thomas");
		dev.setLname("cruze");
		dev.setTitle("se");
		pr.save(dev);
	}
	
	@Test
	public void createPersonHumanoidTest() {
		// fail();
		Humanoid humanoid = new Humanoid();
		humanoid.setId(1);
		humanoid.setFname("zoid");
		humanoid.setLname("fedor");
		humanoid.setHp(98);
		pr.save(humanoid);
	}

}
