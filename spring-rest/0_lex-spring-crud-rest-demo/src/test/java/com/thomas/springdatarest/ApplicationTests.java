package com.thomas.springdatarest;

import static org.junit.jupiter.api.Assertions.fail;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.thomas.springdatarest.exception.InfyBankException;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	@Rollback(false)
	public void updateCustomerTest() throws InfyBankException {
		// fail
		
	}

}
