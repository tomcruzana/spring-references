package com.dev.springdata.hibernateinheritance.repo;

import org.springframework.data.repository.CrudRepository;

import com.dev.springdata.hibernateinheritance.entity.GroundVehicle;

public interface GroundVehicleRepo extends CrudRepository<GroundVehicle, Integer> {

}
