package com.dev.springdata.ps;

/*
 * here you will learn pagination & sorting
 * 
 * steps overview:
 * 
 * 1. extend the PagingAndSortingRepository interface via your repository interface.
 * 	  this extends the crudrepository interface behind the scenes.
 * 
 * 2. check the repo interface
 * 
 * 3. check the test cases for docs
 * */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
