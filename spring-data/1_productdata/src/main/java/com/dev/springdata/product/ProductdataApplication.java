package com.dev.springdata.product;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProductdataApplication {
	
	/*
	 * steps:
	 * 1. create entities
	 * 2. mark w/ jpa annotations
	 * 3. create repos
	 * 4. config data source
	 * 5. config the repo interface and add finder methods you need
	 * */

	public static void main(String[] args) {
		SpringApplication.run(ProductdataApplication.class, args);
		
	}

}
