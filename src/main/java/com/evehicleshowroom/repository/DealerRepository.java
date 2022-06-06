package com.evehicleshowroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.evehicleshowroom.entity.Dealer;

public interface DealerRepository extends JpaRepository<Dealer,Integer>
{
	@Query("select d from Dealer d where d.userName = :uname and d.password = :upwd")
	Dealer login(@Param("uname") String username, @Param("upwd") String password);
	
	Dealer findByEmail(String email);
}

