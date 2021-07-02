package com.dev.springdata.hibernateinheritance;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * The JOINED strategy is the most commonly used strategy
 * The common info is stored in the parent table and then referenced to the child table. 
 * Joined Table – each class has its table and querying a subclass entity requires joining the tables
 * 
 * Annotations:
 * @Inheritance(strategy = InheritanceType.JOINED) - super class level
 * @PrimaryKeyJoinColumn(name = "id") - child class level
 * */

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
