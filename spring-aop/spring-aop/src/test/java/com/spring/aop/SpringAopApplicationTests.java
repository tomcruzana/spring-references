package com.spring.aop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.aop.service.LaptopService;

@SpringBootTest
class SpringAopApplicationTests {

	@Autowired
	LaptopService ls;

	@Test
	void contextLoads() {
	}

	@Test
	public void addLaptopLoggingAdvisesTest() {
		// fail();
		ls.addLaptop();
	}

	@Test
	public void addLaptopLoggingExceptionAdviseTest() {
		// fail();
		assertThrows(IllegalArgumentException.class, () -> {
			ls.addLaptops(false);
	    });
	}
	
	@Test
	public void deleteLaptopLoggingAdvisesPointcutReuseTest() {
		// fail();
		ls.deleteLaptop();
	}
	
	@Test
	public void updateLaptopLoggingAdvisesPointcutReuseAndCombineTest() {
		// fail();
		ls.updateLaptop();
	}


}
