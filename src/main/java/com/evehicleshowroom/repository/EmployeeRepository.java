package com.evehicleshowroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evehicleshowroom.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{

}
