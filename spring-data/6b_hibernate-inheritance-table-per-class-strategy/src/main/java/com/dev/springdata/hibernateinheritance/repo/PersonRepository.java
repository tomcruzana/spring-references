package com.dev.springdata.hibernateinheritance.repo;

import org.springframework.data.repository.CrudRepository;

import com.dev.springdata.hibernateinheritance.entity.Person;

public interface PersonRepository extends CrudRepository<Person ,Integer> {

}
