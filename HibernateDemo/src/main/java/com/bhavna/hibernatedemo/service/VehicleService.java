package com.bhavna.hibernatedemo.service;

import java.util.List;

import com.bhavna.hibernatedemo.entity.Vehicle;

public interface VehicleService {
	public Vehicle getVehicleById(Integer id);
	public List<Vehicle> getVehicles();
	public Vehicle saveVehicle(Vehicle vehicle);
	public Vehicle updateVehicle(Vehicle vehicle);
}
