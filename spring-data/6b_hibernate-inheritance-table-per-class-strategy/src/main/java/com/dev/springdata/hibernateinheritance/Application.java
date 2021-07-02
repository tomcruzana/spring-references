package com.dev.springdata.hibernateinheritance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * As the name states, there's an sql table per entity class!
 * 
 * Table Per Class strategy is the most logical inheritance solution 
 * because it mirrors the object model in the data model. In this pattern
 * a table is defined for each class in the inheritance hierarchy to 
 * store only the local attributes of that class. All classes in the 
 * hierarchy must share the same id attribute.
 * */

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
