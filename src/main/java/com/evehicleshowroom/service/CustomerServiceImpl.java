package com.evehicleshowroom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evehicleshowroom.entity.Customer;
import com.evehicleshowroom.entity.Dealer;
import com.evehicleshowroom.exception.AuthenticationFailedException;
import com.evehicleshowroom.exception.CustomerEmailNotFoundException;
import com.evehicleshowroom.exception.CustomerNotFoundException;
import com.evehicleshowroom.exception.DuplicateEntryException;
import com.evehicleshowroom.exception.ResourceNotFoundException;
import com.evehicleshowroom.repository.CustomerRepository;
import com.evehicleshowroom.repository.DealerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private DealerRepository dealerRepository;

	@Override
	public String login(String userName, String password) {
		Customer customer = customerRepository.login(userName, password);
		if (customer == null) {
			throw new AuthenticationFailedException("Username or Password Invalid");
		}
		return "Logged in successfully";
	}

	@Override
	public Customer addCustomerDetails(Customer customer, int dealerId) {
		Optional<Dealer> optionalDealer = dealerRepository.findById(dealerId);
		if (optionalDealer.isEmpty()) {
			throw new ResourceNotFoundException("Dealer not existing with ID" + dealerId);
		}
		List<Customer> customerList = customerRepository.findAll();
		customerList.forEach(c -> {
			if (customer.getCustomerEmail().equals(c.getCustomerEmail())) {
				throw new DuplicateEntryException("Email already exists");
			}
		});
		Dealer dealer = optionalDealer.get();
		customer.setDealer(dealer);
		return customerRepository.save(customer);

	}

	@Override
	public String updateCustomerPassword(int id, String password) {
		Customer customer = (customerRepository.findById(id)).get();
		if (customer == null) {
			throw new CustomerNotFoundException("Customer not found ");
		}

		customer.setPassword(password);
		customerRepository.save(customer);
		return "Your password has been updated";
	}

	@Override
	public Customer getCustomerByEmail(String customerEmail) {
		Customer optional = customerRepository.findByCustomerEmail(customerEmail);
	
		 if (optional == null) { 
			 throw new CustomerEmailNotFoundException("Customer Email not found "); 
		 }
		return optional;
	}

}
