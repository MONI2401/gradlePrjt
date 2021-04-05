package com.cg.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cars.entities.Customer;
import com.cg.cars.exception.CustomerServiceException;
import com.cg.cars.model.CustomerDTO;
import com.cg.cars.service.CustomerServiceImp;
import com.cg.cars.service.ICustomerService;

@RestController
@RequestMapping("/api/cars")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@PostMapping("/addcustomer")
	public ResponseEntity<CustomerDTO> insertCustomer(@RequestBody Customer customer) throws CustomerServiceException {
		if(CustomerServiceImp.validateUserName(customer) && CustomerServiceImp.ValidateUserDOB(customer) && CustomerServiceImp.validateUserMail(customer)
				&& CustomerServiceImp.ValidateUserContact(customer)) {
		CustomerDTO resultcustomer = customerService.addCustomer(customer);
		return new ResponseEntity<CustomerDTO>(resultcustomer, HttpStatus.OK);
		}
		throw new CustomerServiceException("Invalid Customer Details");
	}

	@DeleteMapping("/deletecustomer/{id}")
	public void deleteCustomer(@PathVariable long id) throws CustomerServiceException {
		customerService.removeCustomer(id);
	}

	@PutMapping("/updatecustomer")
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody Customer customer) {
		CustomerDTO resultCustomer = customerService.updateCustomer(customer);
		return new ResponseEntity<CustomerDTO>(resultCustomer, HttpStatus.OK);
	}

	@GetMapping("/getcustomer/{id}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable long id) {
		CustomerDTO resultCustomer = customerService.getCustomer(id);
		return new ResponseEntity<CustomerDTO>(resultCustomer, HttpStatus.OK);
	}

	@GetMapping("/allcustomers")
	public ResponseEntity<List<CustomerDTO>> getAllCustomer() {
		List<CustomerDTO> resultCustomer = customerService.getAllCustomers();
		return new ResponseEntity<List<CustomerDTO>>(resultCustomer, HttpStatus.OK);
	}

	@GetMapping("/getcustomerCity/{city}") 
	public ResponseEntity<CustomerDTO> getCustomerbyCity(@PathVariable String city) { 
		CustomerDTO resultCustomer =customerService.getCustomersByCity(city); 
		return  new ResponseEntity<CustomerDTO>(resultCustomer, HttpStatus.OK);}

}