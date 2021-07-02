package com.dev.springdata.hibernate.inheritance.repo;

import org.springframework.data.repository.CrudRepository;

import com.dev.springdata.hibernate.inheritance.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
