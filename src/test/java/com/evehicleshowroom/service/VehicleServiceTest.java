package com.evehicleshowroom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.evehicleshowroom.entity.Vehicle;
import com.evehicleshowroom.repository.VehicleRepository;

@SpringBootTest
 class VehicleServiceTest 
{

	@InjectMocks
	private VehicleService vehicleService = new VehicleServiceImpl();
	
	@Mock
	private VehicleRepository vehicleRepository;
	
	@Test
 void testAddVehicleDetails()
	{
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleId(1);
		vehicle.setVehicleName("Polo");
		vehicle.setVehicleModel(2020);
		vehicle.setVehicleMileage(22);
		vehicle.setVehicleCategory(2);
		vehicle.setVehiclePrice(900000);
		when(vehicleRepository.save(vehicle)).thenReturn(vehicle);
		Vehicle newVehicle = vehicleService.addVehicle(vehicle);
		assertEquals("Polo", newVehicle.getVehicleName());
		assertEquals(2020, newVehicle.getVehicleModel());
		assertEquals(22, newVehicle.getVehicleMileage());
		}
		
	}

