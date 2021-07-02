package com.dev.springdata.component.mapping.repository;

import org.springframework.data.repository.CrudRepository;

import com.dev.springdata.component.mapping.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
	
}
