package com.evehicleshowroom.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evehicleshowroom.entity.Response;
import com.evehicleshowroom.service.ResponseService;

@RestController
public class ResponseController {

	@Autowired
	private ResponseService responseService;

	@PostMapping("/response/save/{communicationId}")
	public ResponseEntity<Response> addResponse(@PathVariable int communicationId,
			@Valid @RequestBody Response response) {
		Response newResponse = responseService.addResponseDetails(response, communicationId);
		return new ResponseEntity<>(newResponse, HttpStatus.CREATED);
	}

}
