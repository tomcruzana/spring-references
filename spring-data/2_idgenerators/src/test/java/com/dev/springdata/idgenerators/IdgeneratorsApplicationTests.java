package com.dev.springdata.idgenerators;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dev.springdata.idgenerators.entities.Employee;
import com.dev.springdata.idgenerators.repositories.EmployeeCrudRepository;

@SpringBootTest
class IdgeneratorsApplicationTests {
	@Autowired
	EmployeeCrudRepository employeeRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployee() {
		Employee employee = new Employee();
		//employee.setId(100L);
		employee.setName("sammy");
		employeeRepo.save(employee);
	}

}
