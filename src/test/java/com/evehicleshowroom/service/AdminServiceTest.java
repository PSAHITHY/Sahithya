package com.evehicleshowroom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.evehicleshowroom.entity.Admin;
import com.evehicleshowroom.exception.AuthenticationFailedException;
import com.evehicleshowroom.repository.AdminRepository;

@SpringBootTest
 class AdminServiceTest {
	@InjectMocks
	private AdminService adminService = new AdminServiceImpl();

	@Mock
	private AdminRepository adminRepository;

	@Test
 void testAddAdminDetails() {
		Admin admin = new Admin();
		admin.setAdminId(1);
		admin.setUserName("abc");
		admin.setPassword("abc123");

		when(adminRepository.save(admin)).thenReturn(admin);
		Admin newAdmin = adminService.addAdminDetails(admin);
		assertEquals("abc", newAdmin.getUserName());

		verify(adminRepository, times(1)).save(admin);
	}

	@Test
	 void testLogin() {
		Admin admin = new Admin();
		admin.setAdminId(1);
		admin.setUserName("abc");
		admin.setPassword("abc123");

		when(adminRepository.login(admin.getUserName(), admin.getPassword())).thenReturn(admin);
		assertEquals("abc", admin.getPassword());
		assertEquals("abc", admin.getUserName());
	}


}
