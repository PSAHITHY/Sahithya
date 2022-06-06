package com.evehicleshowroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evehicleshowroom.entity.Dealer;
import com.evehicleshowroom.exception.AuthenticationFailedException;
import com.evehicleshowroom.exception.DealerEmailNotFoundException;
import com.evehicleshowroom.exception.DuplicateEntryException;
import com.evehicleshowroom.repository.DealerRepository;

@Service
public class DealerServiceImpl implements DealerService {
	@Autowired
	private DealerRepository dealerRepository;

	@Override
	public String login(String userName, String password) {
		Dealer dealer = dealerRepository.login(userName, password);
		if (dealer == null) {
			throw new AuthenticationFailedException("Username or Password Invalid");
		}
		return "Logged in successfully";
	}

	@Override
	public Dealer addDealerDetails(Dealer dealer) {
		List<Dealer> dealerList = dealerRepository.findAll();
		dealerList.forEach(d -> {
			if (dealer.getEmail().equals(d.getEmail())) {
				throw new DuplicateEntryException("Email already exists");
			}
		});
		return dealerRepository.save(dealer);
	}

	@Override
	public Dealer getDealerByEmail(String email) {
		Dealer dealer = dealerRepository.findByEmail(email);
		if (dealer == null) {
			throw new DealerEmailNotFoundException("dealer email not found ");
		}
		return dealer;

	}
}
