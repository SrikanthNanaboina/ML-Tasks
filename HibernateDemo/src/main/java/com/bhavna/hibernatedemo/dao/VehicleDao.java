package com.bhavna.hibernatedemo.dao;

import java.util.List;

import com.bhavna.hibernatedemo.entity.Vehicle;

public interface VehicleDao {
	public Vehicle getVehicleById(Integer id);
	public List<Vehicle> getVehicles();
	public Vehicle saveVehicle(Vehicle vehicle);
	public Vehicle updateVehicle(Vehicle vehicle);
}
