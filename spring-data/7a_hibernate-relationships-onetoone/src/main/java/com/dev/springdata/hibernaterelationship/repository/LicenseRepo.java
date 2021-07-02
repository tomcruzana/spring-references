package com.dev.springdata.hibernaterelationship.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dev.springdata.hibernaterelationship.entities.License;

public interface LicenseRepo extends CrudRepository<License, Integer> {

	// read using native SQL
	// we use object as a return type since this will return 2 Object types (License
	// & Person)
	@Query(value = "select * from license where license_number = :id", nativeQuery = true)
	public List<Object[]> findLicenseById(@Param("id") Integer id);
	
	// update
	@Modifying
	@Query(value = "update license set license_number = :newId where license_number = :id", nativeQuery = true)
	public void updateLicenseById(@Param("newId") Integer newId, @Param("id") Integer id);
	
	// delete using JPA query method
	public void deleteByLicenseNumber(Integer id);

}
