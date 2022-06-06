package com.evehicleshowroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.evehicleshowroom.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>
{
	@Query("select a from Admin a where a.userName = :uname and a.password = :upwd")
	Admin login(@Param("uname") String username, @Param("upwd") String password);
}
