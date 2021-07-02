package com.dev.springdata.hibernate.inheritance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateInheritanceApplication {

	/*
	 * In a nut shell, this is like component/composition mapping but we
	 * are using inheritance. We have a single table and we have super and child classes
	 * working together to fill out a single table in a db. 
	 * 
	 * The single table strategy maps all entities of the inheritance structure to
	 * the same database table. This approach makes polymorphic queries very
	 * efficient and provides the best performance. But it also has some drawbacks.
	 * The attributes of all entities are mapped to the same database table.
	 * 
	 * Video:
	 * https://www.youtube.com/watch?v=vgrRfiogKUQ
	 */
	public static void main(String[] args) {
		SpringApplication.run(HibernateInheritanceApplication.class, args);
	}

}
