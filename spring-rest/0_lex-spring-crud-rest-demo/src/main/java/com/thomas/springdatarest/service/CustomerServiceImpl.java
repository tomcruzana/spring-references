package com.thomas.springdatarest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomas.springdatarest.dto.CustomerDTO;
import com.thomas.springdatarest.entities.Customer;
import com.thomas.springdatarest.exception.InfyBankException;
import com.thomas.springdatarest.repository.CustomerRepository;

@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public CustomerDTO getCustomer(Integer customerId) throws InfyBankException {
		// get cx details using customer repo spring data built-in method
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));

		// if cx info is present, prep and hand it to its DTO type for data transfer to
		// the rest controller
		CustomerDTO customer2 = new CustomerDTO();
		customer2.setCustomerId(customer.getCustomerId());
		customer2.setEmailId(customer.getEmailId());
		customer2.setName(customer.getName());
		customer2.setDateOfBirth(customer.getDateOfBirth());
		return customer2;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() throws InfyBankException {
		// get cx details using customer repo spring data built-in method
		Iterable<Customer> customerList = customerRepository.findAll();

		// if cx info is present, prep and hand it to its DTO type for data transfer to
		// the rest controller
		List<CustomerDTO> customerList2 = new ArrayList<>();
		customerList.forEach(cx -> {
			CustomerDTO cx2 = new CustomerDTO();
			cx2.setCustomerId(cx.getCustomerId());
			cx2.setEmailId(cx.getEmailId());
			cx2.setName(cx.getName());
			cx2.setDateOfBirth(cx.getDateOfBirth());
			customerList2.add(cx2);
		});

		// handle exception if list is empty
		if (customerList2.isEmpty()) {
			throw new InfyBankException("Service.CUSTOMERS_NOT_FOUND");
		}
		return customerList2;
	}

	@Override
	public Integer addCustomer(CustomerDTO customer) throws InfyBankException {
		Customer customerEntity = new Customer();
		customerEntity.setCustomerId(customer.getCustomerId());
		customerEntity.setName(customer.getName());
		customerEntity.setEmailId(customer.getEmailId());
		customerEntity.setDateOfBirth(customer.getDateOfBirth());

		Customer customerEntity2 = customerRepository.save(customerEntity);
		// we need an int type response so we use the customer id
		return customerEntity2.getCustomerId();
	}

	@Override
	public void updateCustomer(Integer customerId, String emailId) throws InfyBankException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customerEntity = optional.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
		customerEntity.setEmailId(emailId);
	}

	@Override
	public void deleteCustomer(Integer customerId) throws InfyBankException {
		Optional<Customer> customer = customerRepository.findById(customerId);
		customer.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
		customerRepository.deleteById(customerId);
	}

}
