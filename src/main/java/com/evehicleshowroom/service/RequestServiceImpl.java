package com.evehicleshowroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evehicleshowroom.entity.Customer;
import com.evehicleshowroom.entity.Dealer;
import com.evehicleshowroom.entity.Request;
import com.evehicleshowroom.exception.CustomerEmailNotFoundException;
import com.evehicleshowroom.exception.DealerEmailNotFoundException;
import com.evehicleshowroom.repository.RequestRepository;

@Service
public class RequestServiceImpl implements RequestService {
	@Autowired
	private RequestRepository requestRepository;

	@Autowired
	private CustomerService customerService = new CustomerServiceImpl();

	@Autowired
	private DealerService dealerService = new DealerServiceImpl();

	@Override
	public Request addRequestDetails(Request request) {
		Customer customer = customerService.getCustomerByEmail(request.getFromEmail());
		if (customer == null) {
			throw new CustomerEmailNotFoundException("Customer Email not found ");
		}
		Dealer dealer = dealerService.getDealerByEmail(request.getToEmail());
		if (dealer == null) {
			throw new DealerEmailNotFoundException("dealer email not found ");
		}

		return requestRepository.save(request);
	}
}
