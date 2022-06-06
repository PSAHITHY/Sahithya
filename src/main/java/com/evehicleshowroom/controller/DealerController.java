package com.evehicleshowroom.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evehicleshowroom.entity.Dealer;
import com.evehicleshowroom.model.LoginRequest;
import com.evehicleshowroom.service.DealerService;

@RestController
public class DealerController {
	@Autowired
	private DealerService dealerService;

	@PostMapping("/dealer/add")
	public ResponseEntity<Dealer> addDealer(@Valid @RequestBody Dealer dealer) {
		Dealer dealer1 = dealerService.addDealerDetails(dealer);
		return new ResponseEntity<>(dealer1, HttpStatus.CREATED);

	}

	@PostMapping("/dealer/login")
	public ResponseEntity<Object> signin(@RequestBody LoginRequest loginRequest) {
		String response = dealerService.login(loginRequest.getUserName(), loginRequest.getPassword());
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
