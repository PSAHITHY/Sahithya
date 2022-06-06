package com.evehicleshowroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evehicleshowroom.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer>
{

}
