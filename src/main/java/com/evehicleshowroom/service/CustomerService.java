package com.evehicleshowroom.service;

import com.evehicleshowroom.entity.Customer;

public interface CustomerService {
	Customer addCustomerDetails(Customer customer, int dealerId);

	String updateCustomerPassword(int id, String password);

	Customer getCustomerByEmail(String customerEmail);
	String login(String userName, String password);
}
