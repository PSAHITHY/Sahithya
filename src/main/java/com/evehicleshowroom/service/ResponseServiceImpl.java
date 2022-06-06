package com.evehicleshowroom.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evehicleshowroom.entity.Customer;
import com.evehicleshowroom.entity.Dealer;
import com.evehicleshowroom.entity.Request;
import com.evehicleshowroom.entity.Response;
import com.evehicleshowroom.exception.CustomerEmailNotFoundException;
import com.evehicleshowroom.exception.DealerEmailNotFoundException;
import com.evehicleshowroom.exception.ResourceNotFoundException;
import com.evehicleshowroom.repository.RequestRepository;
import com.evehicleshowroom.repository.ResponseRepository;

@Service
public class ResponseServiceImpl implements ResponseService {

	@Autowired
	private ResponseRepository responseRepository;

	@Autowired
	private RequestRepository requestRepository;

	@Autowired
	private DealerServiceImpl dealerService;

	@Autowired
	private CustomerServiceImpl customerService;

	@Override
	public Response addResponseDetails(Response response, int requestId) {
		Optional<Request> optionalrequest = requestRepository.findById(requestId);
		if (optionalrequest.isEmpty()) {
			throw new ResourceNotFoundException("request ID does not exists" + requestId);
		}

		Dealer dealer = dealerService.getDealerByEmail(response.getFromEmail());
		if (dealer == null) {
			throw new DealerEmailNotFoundException("dealer email not found ");
		}
		Customer customer = customerService.getCustomerByEmail(response.getToEmail());
		if (customer == null) {
			throw new CustomerEmailNotFoundException("Email not found ");
		}
		Request request = optionalrequest.get();
		response.setRequest(request);
		return responseRepository.save(response);

	}
}
