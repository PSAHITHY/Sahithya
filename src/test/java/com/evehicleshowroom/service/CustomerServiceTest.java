package com.evehicleshowroom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.evehicleshowroom.entity.Customer;
import com.evehicleshowroom.entity.Dealer;
import com.evehicleshowroom.repository.CustomerRepository;
import com.evehicleshowroom.repository.DealerRepository;

@SpringBootTest
public class CustomerServiceTest {
	@InjectMocks
	private CustomerService customerService = new CustomerServiceImpl();
	@Mock
	private DealerRepository dealerRepository;
	@Mock
	private CustomerRepository customerRepository;

	@Test
	void addCustomerDetailsTest() {

		Dealer dealer = new Dealer();
		dealer.setDealerId(1);
		dealer.setDealerName("dealer1");
		dealer.setEmail("dealer1@gmail.com");

		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("Meghana");
		customer.setCustomerEmail("meghana@gmail.com");
		customer.setAddress("Hyderabad");
		customer.setDealer(dealer);

		when(dealerRepository.findById(1)).thenReturn(Optional.of(dealer));
		when(customerRepository.save(customer)).thenReturn(customer);
		Customer newCustomer = customerService.addCustomerDetails(customer, 1);
		assertEquals("Meghana", newCustomer.getCustomerName());

	}
}
