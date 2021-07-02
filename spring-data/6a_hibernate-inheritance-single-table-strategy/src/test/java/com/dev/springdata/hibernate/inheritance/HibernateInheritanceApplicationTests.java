package com.dev.springdata.hibernate.inheritance;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dev.springdata.hibernate.inheritance.entities.Check;
import com.dev.springdata.hibernate.inheritance.entities.CreditCard;
import com.dev.springdata.hibernate.inheritance.repo.PaymentRepository;

@SpringBootTest
class HibernateInheritanceApplicationTests {

	@Autowired
	PaymentRepository pr;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void createCreditCardPaymentTest() {
		// fail();
		CreditCard creditPayment = new CreditCard();
		creditPayment.setAmount(100.00);
		creditPayment.setCreditCardNumber("123-1234-12345");
		pr.save(creditPayment);
	}
	
	@Test
	public void createCheckCardPaymentTest() {
		// fail();
		Check checkPayment = new Check();
		checkPayment.setAmount(100.00);
		checkPayment.setCreditCardNumber("000-100-1102");
		pr.save(checkPayment);
	}
}
