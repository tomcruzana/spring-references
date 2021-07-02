package com.dev.springdata.jpqlandsql.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.dev.springdata.jpqlandsql.entities.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

	// JPQL demo-------------------------------------
	// -uses the entity class properties instead of native sql column names
	// -select keyword is optional if all columns are involved in the query
	// -if selecting all columns, no need for the * wildcard

	// selects all
	@Query("from Customer")
	public List<Customer> findAllCustomers();

	// select partial data. note it returns an object[] array if not all
	// properties/columns are being selected!
	@Query("select firstName, longitude, latitude from Customer")
	public List<Object[]> findCustomersByNameAndCoords();

	// select with names query paramerters. note :param can be any name!
	@Query("from Customer where lastName = :customerLastName")
	public List<Customer> findByCustomerLastName(@Param("customerLastName") String customerLastName);

	@Query("from Customer where id between :min and :max")
	public List<Customer> findByCustomerWithMinMaxIds(@Param("min") int min, @Param("max") int max);

	// important!
	// delete, update, insert must be marked with @Modifying annotation
	// the test case must be marked with @Transactional since we are performing a
	// DML operation
	@Modifying
	@Query("delete from Customer where id = :cx_id")
	public void deleteCustomer(@Param("cx_id") int id);

	// pagination & sorting
	@Query("select id, latitude, longitude from Customer")
	public List<Object[]> findCustomerByIdLatLong(Pageable pageable);

	// NATIVE SQL demo-------------------------------------
	// -by default spring data is set to JPQL so you need to let it know by
	// providing the syntax below
	// 
	// -use the db column names instead of entity properties
	//
	// -syntax Query(value=VALID SQL, nativeQuery=true)
	//
	// -Object[] is the type it will return if not all columns are provide otherwise
	// use the entity type
	//
	// -user native sql for complex queries as a best practice
	@Query(value = "select id, fname, lname from customer_table", nativeQuery = true)
	public List<Object[]> findByNativeSqlColumns();
	
	// same in jpql, select named params using query paramerters. note :param can be any name!
	@Query(value="select * from customer_table where id = :cx_id", nativeQuery = true)
	public List<Customer> findByNativeSqlWithParams(@Param("cx_id") int id);
}
