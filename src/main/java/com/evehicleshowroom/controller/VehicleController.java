package com.evehicleshowroom.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evehicleshowroom.entity.Vehicle;
import com.evehicleshowroom.service.VehicleService;

@RestController
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;

	@PostMapping("/vehicle/add")
	public ResponseEntity<Vehicle> putInVehicleDetails(@Valid @RequestBody Vehicle vehicle) {
		Vehicle newVehicle = vehicleService.addVehicle(vehicle);
		return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);

	}

}
