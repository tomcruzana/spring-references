package com.dev.springdata.hibernateinheritance;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dev.springdata.hibernateinheritance.entity.Car;
import com.dev.springdata.hibernateinheritance.repo.GroundVehicleRepo;

@SpringBootTest
class ApplicationTests {

	@Autowired
	GroundVehicleRepo gvr;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void createVehicleTest() {
		// fail();
		Car car = new Car();
		// car.setId(1); //should auto increment
		car.setBrand("toyota");
		car.setColor("black");
		car.setMake("2021");
		car.setModel("camry");
		car.setnumberOfwheels(4);
		car.setPrice(8000.00);
		gvr.save(car);
	}

}
