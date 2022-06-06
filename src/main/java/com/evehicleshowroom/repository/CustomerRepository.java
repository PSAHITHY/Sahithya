package com.evehicleshowroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.evehicleshowroom.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>
{
	@Query("select c from Customer c where c.userName = :uname and c.password = :upwd")
	Customer login(@Param("uname") String username, @Param("upwd") String password);
	
	@Query("update Customer c set c.password= :pwd where c.customerId= :id")
	Customer update(@Param("id") int userId,@Param("pwd") String password);
	
	Customer findByCustomerEmail(String customerEmail);
}
