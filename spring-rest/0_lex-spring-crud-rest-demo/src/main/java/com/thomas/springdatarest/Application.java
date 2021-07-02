package com.thomas.springdatarest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.thomas.springdatarest.dto.CustomerDTO;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Log LOGGER = LogFactory.getLog(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	private Integer price;
	// THE COMMAND LINE RUNNER THAT WILL EXECUTE OUR CODE AFTER SPRING BOOT STARTS
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("asd");

		// getCustomerDetails(2);
//		
//		CustomerDTO customerDTO = new CustomerDTO();
//		customerDTO.setEmailId("peter@infy.com");
//		customerDTO.setName("Peter");
//		addCustomer(customerDTO);
//		
//		CustomerDTO customerDTO1 = new CustomerDTO();
//		customerDTO1.setCustomerId(4);
//		customerDTO1.setEmailId("peter@infy.com");
//		customerDTO1.setName("Peter");
//		updateCustomer(customerDTO1);
//		
//		deleteCustomer(1);

	}

	/*
	 * CONSUMING CRUD API REST USING REST TEMPLATE CAVEAT: THIS IS ALMOST DEPRECATED
	 * 
	 * DOCS: https://www.baeldung.com/rest-template https://bit.ly/2TGax8W
	 */
	public void getCustomerDetails(Integer customerId) {
		String url = "http://localhost:8765/infybank/customers/{customerId}";
		RestTemplate restTemplate = new RestTemplate();
		CustomerDTO customerDTO = restTemplate.getForObject(url, CustomerDTO.class, customerId);
		LOGGER.info(customerDTO);
		LOGGER.info("\n");
	}

	public void addCustomer(CustomerDTO customer) {
		String url = "http://localhost:8765/infybank/customers";
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject(url, customer, String.class);
		LOGGER.info(response);
		LOGGER.info("\n");
	}

	public void updateCustomer(CustomerDTO customerDTO) {
		String url = "http://localhost:8765/infybank/customers/{customerId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(url, customerDTO, customerDTO.getCustomerId());
		LOGGER.info("Customer updated successfully");
		LOGGER.info("\n");
	}

	public void deleteCustomer(Integer customerId) {
		String url = "http://localhost:8765/infybank/customers/{customerId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url, customerId);
		LOGGER.info("Customer deleted successfully");
		LOGGER.info("\n");
	}
}
