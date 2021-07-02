package com.thomas.springdatarest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.thomas.springdatarest.dto.CustomerDTO;
import com.thomas.springdatarest.exception.InfyBankException;
import com.thomas.springdatarest.service.CustomerService;

// article about CORS: // https://bit.ly/2SFASUG
@CrossOrigin
@RestController
@RequestMapping(value = "/infybank")
public class CustomerAPI {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private Environment environment;

	/*
	 * Spring 5 introduced the ResponseStatusException class. This is a base class
	 * for exceptions associated with specific HTTP status codes. You can create an
	 * instance of it by providing an HttpStatus code, a message to explain the
	 * exception and cause of the exception as follows:
	 */
	@GetMapping(value = "/customer/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer customerId) throws InfyBankException {

		try {
			// from the url mapping we grab the data and pass it to the service class so it
			// can be processed
			CustomerDTO customer = customerService.getCustomer(customerId);

			// once done, we return a response entity object with the requested info
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()),
					exception);
		}

	}

	@GetMapping(value = "/customers")
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() throws InfyBankException {
		// from the url mapping we grab the data and pass it to the service class so it
		// can be processed
		List<CustomerDTO> allCustomers = customerService.getAllCustomers();

		// once done, we return a response entity object with the requested info
		return new ResponseEntity<>(allCustomers, HttpStatus.OK);
	}

	@PostMapping(value = "/customers")
	public ResponseEntity<String> addCustomer(@RequestBody CustomerDTO customer) throws InfyBankException {
		// from the url mapping we grab the data and pass it to the service class so it
		// can be processed
		// the @RequestBody contains the json object that'll be serialized
		Integer customerId = customerService.addCustomer(customer);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + customerId;

		// once done, we return a response entity object with the requested info
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

	@PutMapping(value = "/customers/{customerId}")
	public ResponseEntity<String> updateCustomer(@PathVariable Integer customerId, @RequestBody CustomerDTO customer)
			throws InfyBankException {
		// from the url mapping we grab the data and pass it to the service class so it
		// can be processed
		// the @RequestBody contains the json object that'll be serialized
		customerService.updateCustomer(customerId, customer.getEmailId());
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS");

		// once done, we return a response entity object with the requested info
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

	@DeleteMapping(value = "/customer/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId) throws InfyBankException {
		customerService.deleteCustomer(customerId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
}