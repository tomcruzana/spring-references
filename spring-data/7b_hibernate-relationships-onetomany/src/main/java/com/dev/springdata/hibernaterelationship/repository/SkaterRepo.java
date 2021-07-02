package com.dev.springdata.hibernaterelationship.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dev.springdata.hibernaterelationship.entities.Skater;

public interface SkaterRepo extends CrudRepository<Skater, Integer> {
	public List<Skater> findById(int id);
}
