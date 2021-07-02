package com.dev.springdata.component.mapping;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dev.springdata.component.mapping.entities.Laptop;
import com.dev.springdata.component.mapping.entities.Order;
import com.dev.springdata.component.mapping.repository.OrderRepository;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private OrderRepository orderRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void createOrderAndLaptopTest() {
		Date d = new Date();
		Order customerOrder = new Order();
		customerOrder.setDateOrdered(d);
		customerOrder.setDateDelivered(d);

		Laptop customerLaptop = new Laptop();
		customerLaptop.setBrand("dell");
		customerLaptop.setModel("xps");
		customerOrder.setLaptop(customerLaptop);
		orderRepo.save(customerOrder);
	}

	@Test
	public void deleteAllRows() {
		orderRepo.deleteAll();
	}
}
