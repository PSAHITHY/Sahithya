package com.evehicleshowroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evehicleshowroom.entity.Admin;
import com.evehicleshowroom.exception.AuthenticationFailedException;
import com.evehicleshowroom.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public String doLogin(String userName, String password) {
		Admin admin = adminRepository.login(userName, password);
		if (admin == null) {
			throw new AuthenticationFailedException("Username or Password Invalid");
		}
		return "Logged in successfully";
	}

	@Override
	public Admin addAdminDetails(Admin admin) {
		return adminRepository.save(admin);
	}

}
