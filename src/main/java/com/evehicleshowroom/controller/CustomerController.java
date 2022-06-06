package com.evehicleshowroom.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evehicleshowroom.entity.Customer;
import com.evehicleshowroom.model.LoginRequest;
import com.evehicleshowroom.model.PasswordRequest;
import com.evehicleshowroom.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/customer/add/{dealerId}")
	public ResponseEntity<Customer> addCustomer(@PathVariable int dealerId, @Valid @RequestBody Customer customer) {
		Customer customer1 = customerService.addCustomerDetails(customer, dealerId);
		return new ResponseEntity<>(customer1, HttpStatus.CREATED);

	}

	@PostMapping("/customer/login")
	public ResponseEntity<Object> signin(@RequestBody LoginRequest loginRequest) {
		String response = customerService.login(loginRequest.getUserName(), loginRequest.getPassword());
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PostMapping("/customer/reset")
	public ResponseEntity<Object> resetPassword(@RequestBody PasswordRequest passwordRequest) {
		String response = customerService.updateCustomerPassword(passwordRequest.getUserId(),
				passwordRequest.getPassword());
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
