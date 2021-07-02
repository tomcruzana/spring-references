package com.dev.springdata.ps.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dev.springdata.ps.entities.Laptop;

// here we extend PagingAndSortingRepository interface
public interface LaptopRepository extends PagingAndSortingRepository<Laptop, Integer> {
	// custom finder method
	List<Laptop> findById(int id);

	// custom finder method with pageable enabled.
	// Note that it's a Page type
	Page<Laptop> findByPriceGreaterThan(double price, Pageable pageable);
}
