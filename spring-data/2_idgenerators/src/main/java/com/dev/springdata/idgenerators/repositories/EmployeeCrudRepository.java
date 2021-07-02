package com.dev.springdata.idgenerators.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dev.springdata.idgenerators.entities.Employee;

public interface EmployeeCrudRepository extends CrudRepository<Employee, Long> {

}
