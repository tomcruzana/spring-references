package com.dev.springdata.finderdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dev.springdata.finderdemo.entities.Department;

public interface DepartmentCrudRepo extends CrudRepository<Department, Integer> {

	// Doc:
	// https://docs.spring.io/spring-data/data-jpa/docs/1.4.x/reference/htmlsingle/#repository-query-keywords

	// hibernate will auto map your fields by using keywords in the doc above and
	// execute need sql query behind the scenes.
	// ex: And, Or, etc.

	//find by a single field
	List<Department> findByname(String name);

	// find by multiple fields
	List<Department> findByNameAndTuition(String name, double tuition);
	
	// find by greater than <number>
	List<Department> findByEnrolledStudentsGreaterThan(int num);
	
	// find by ending with keyword
	List<Department> findByNameEndingWith(String word);
	
	// find by contains with keyword
	List<Department> findByNameContains(String word);
	
	// find by between 2 given numbers
	List<Department> findByTuitionBetween(double tuition1, double tuition2);
	
	// find by like keywords. note: use % or _
	List<Department> findByNameLike(String word);
	
	// find by IN via ids
	List<Department> findByIdIn(List<Integer> ids);
}
