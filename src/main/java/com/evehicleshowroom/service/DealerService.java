package com.evehicleshowroom.service;

import com.evehicleshowroom.entity.Dealer;

public interface DealerService {
	String login(String userName, String password);

	Dealer addDealerDetails(Dealer dealer);

	Dealer getDealerByEmail(String email);
}
