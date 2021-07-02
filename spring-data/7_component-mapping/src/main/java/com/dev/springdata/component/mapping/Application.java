package com.dev.springdata.component.mapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	/*
	 * @Embeddable -class level
	 * @Embedded - property level
	 * this is how you use multiple classes and persist data into a single table
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
