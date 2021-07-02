package com.dev.springdata.product.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dev.springdata.product.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
