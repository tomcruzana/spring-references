package com.infy.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.CustomerDTO;
import com.infy.service.CustomerService;

/*
 * 
 * For this, annotate the controller class with @Validated annotation 
 * to tell Spring to validate path variables and request parameters. 
 * Then annotate the parameters of the handler methods which needs to 
 * be validated with constraint annotations.
 * 
 * 
 * */

@RestController
@RequestMapping(value = "/infybank")
@Validated
public class CustomerAPI {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private Environment environment;

	@GetMapping(value = "/")
	public String get() {
		return "getty";
	}
	
	@RequestMapping("/products/{productId}") 
	public String yoyo(@PathVariable String productId){
		return productId;
	}

	@GetMapping("/login")
	public String authenticate(@RequestParam("password") String pwd, @RequestParam("loginName") String name) {
		return name + pwd;
	}

	@GetMapping(value = "/customers")
	public ResponseEntity<List<CustomerDTO>> getAllCustomerDetails() throws Exception {
		List<CustomerDTO> customerList = customerService.getAllCustomers();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}

	// here we put path variable validation feature
	@GetMapping(value = "/customers/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomerDetails(
			@PathVariable @Min(value = 1, message = "Customer id should be between 1 and 100") @Max(value = 100, message = "Customer id should be between 1 and 100") Integer customerId)
			throws Exception {
		CustomerDTO customer = customerService.getCustomer(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@PostMapping(value = "/customers")
	public ResponseEntity<String> addCustomer(@Valid @RequestBody CustomerDTO customerDTO) throws Exception {
		Integer customerId = customerService.addCustomer(customerDTO);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + customerId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

	@PutMapping(value = "/customers/{customerId}")
	public ResponseEntity<String> updateCustomer(@PathVariable Integer customerId, @RequestBody CustomerDTO customer)
			throws Exception {
		customerService.updateCustomer(customerId, customer.getEmailId());
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

	@DeleteMapping(value = "/customers/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId) throws Exception {
		customerService.deleteCustomer(customerId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
}
