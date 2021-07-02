package com.dev.springdata.finderdemo;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dev.springdata.finderdemo.entities.Department;
import com.dev.springdata.finderdemo.repositories.DepartmentCrudRepo;

// finder query tests

@SpringBootTest
class SpringdataFindermethodsApplicationTests {

	@Autowired
	DepartmentCrudRepo dr;
	
	@PersistenceContext
	EntityManager em;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void findByName() {
		// findByname or findByName is acceptable
		List<Department> department = dr.findByname("comsci101");

		// via streams & lambda (shortened way)
		// department.forEach((d)->System.out.println(d.getName()));

		// via iterator (long way)
		Iterator<Department> it = department.iterator();
		while (it.hasNext()) {
			Department dep = it.next();

			String name = dep.getName();
			double tuition = dep.getTuition();
			System.out.println(name + " | " + tuition);
		}
	}

	@Test
	public void findByNameAndTuition() {
		List<Department> department = dr.findByNameAndTuition("comsci101", 1200.00);
		department.forEach((d) -> {
			System.out.println(d.getName() + "\n" + d.getEnrolledStudents());
		});
	}

	@Test
	public void findByEnrolledStudentsGreaterThan() {
		List<Department> department = dr.findByEnrolledStudentsGreaterThan(45);
		department.forEach((d) -> System.out.println(d.getName() + " | " + d.getEnrolledStudents()));
	}

	@Test
	public void findByNameEndingWith() {
		List<Department> department = dr.findByNameEndingWith("101");
		department.forEach((d) -> System.out.println(d.getName()));
	}

	@Test
	public void findByNameContains() {
		List<Department> department = dr.findByNameContains("102");
		department.forEach((d) -> System.out.println(d.getName()));
	}

	@Test
	public void findByTuitionBetween() {
		List<Department> department = dr.findByTuitionBetween(2000.00, 3000.00);
		department.forEach((d) -> System.out.println(d.getName() + " | " + d.getTuition()));
	}
	
	@Test
	public void findByNameLike() {
		// using the % wildcard
		List<Department> department1 = dr.findByNameLike("%sy%");
		department1.forEach((d) -> System.out.println(d.getName()));
		
		// using the _ wildcard
		List<Department> department2 = dr.findByNameLike("com___10_");
		department2.forEach((d) -> System.out.println(d.getName()));
	}
	
	@Test
	public void findByIdIn() {
		List<Integer> ids = new ArrayList<>();
		ids.add(5); // should return nothing since there's no such dept
		ids.add(9);
		ids.add(7);
		
		List<Department> department = dr.findByIdIn(ids);
		department.forEach((d) -> System.out.println(d.getName() + " | " + d.getTuition()));
	}
}
