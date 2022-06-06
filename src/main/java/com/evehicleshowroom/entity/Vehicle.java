package com.evehicleshowroom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "vehicle_table")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id")
	private int vehicleId;
	@NotNull(message = "Please enter vehicle name")
	@Column(name = "vehicle_name")
	private String vehicleName;
	@Positive(message = "Vehicle price must be a positive number")
	@Column(name = "vehicle_price")
	private double vehiclePrice;
	@Positive(message = "Vehicle price must be a positive number")
	@NotNull(message = "Please enter vehicle model")
	@Column(name = "vehicle_model")
	private int vehicleModel;
	@Positive(message = "Vehicle mileage must be a positive number")
	@NotNull(message = "Please enter vehicle mileage")
	@Column(name = "vehicle_mileage")
	private int vehicleMileage;
	@Positive(message = "Vehicle price must be a positive number")
	@NotNull(message = "Please enter vehicle category")
	@Column(name = "vehicle_category")
	private int vehicleCategory;

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public double getVehiclePrice() {
		return vehiclePrice;
	}

	public void setVehiclePrice(double vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}

	public int getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(int vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public int getVehicleMileage() {
		return vehicleMileage;
	}

	public void setVehicleMileage(int vehicleMileage) {
		this.vehicleMileage = vehicleMileage;
	}

	public int getVehicleCategory() {
		return vehicleCategory;
	}

	public void setVehicleCategory(int vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

}
