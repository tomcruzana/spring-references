package com.thomas.springdatarest.repository;

import org.springframework.data.repository.CrudRepository;

import com.thomas.springdatarest.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
