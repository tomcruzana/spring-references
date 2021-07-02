package com.dev.springdata.hibernaterelationship.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dev.springdata.hibernaterelationship.entities.Salesman;

public interface SalesmanRepo extends CrudRepository<Salesman, Integer> {
	public List<Salesman> findById(int id);
}
