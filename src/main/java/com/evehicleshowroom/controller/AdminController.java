package com.evehicleshowroom.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evehicleshowroom.entity.Admin;
import com.evehicleshowroom.model.LoginRequest;
import com.evehicleshowroom.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/admin/add")
	public ResponseEntity<Admin> putInAdminDetails(@Valid @RequestBody Admin admin) {
		Admin newAdmin = adminService.addAdminDetails(admin);
		return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
	}

	@PostMapping("/admin/login")
	public ResponseEntity<Object> signin(@RequestBody LoginRequest loginRequest) {
		String response = adminService.doLogin(loginRequest.getUserName(), loginRequest.getPassword());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
