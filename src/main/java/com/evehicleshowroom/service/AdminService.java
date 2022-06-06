package com.evehicleshowroom.service;

import com.evehicleshowroom.entity.Admin;

public interface AdminService 
{
	String doLogin(String userName, String password);
	Admin addAdminDetails(Admin admin);
}
