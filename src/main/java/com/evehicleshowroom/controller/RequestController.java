package com.evehicleshowroom.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evehicleshowroom.entity.Request;
import com.evehicleshowroom.service.RequestService;

@RestController
public class RequestController {
	@Autowired
	private RequestService requestService;

	@PostMapping("/request/save")
	public ResponseEntity<Request> addRequest(@Valid @RequestBody Request request) {
		Request newRequest = requestService.addRequestDetails(request);
		return new ResponseEntity<>(newRequest, HttpStatus.CREATED);
	}
}
