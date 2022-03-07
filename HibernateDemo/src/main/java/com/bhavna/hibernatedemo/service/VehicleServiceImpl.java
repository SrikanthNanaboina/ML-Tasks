package com.bhavna.hibernatedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.hibernatedemo.dao.VehicleDao;
import com.bhavna.hibernatedemo.entity.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	VehicleDao dao;

	@Override
	public Vehicle getVehicleById(Integer id) {
		return dao.getVehicleById(id);
	}

	@Override
	public List<Vehicle> getVehicles() {
		return dao.getVehicles();
	}

	@Override
	public Vehicle saveVehicle(Vehicle vehicle) {
		return dao.saveVehicle(vehicle);
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		return dao.updateVehicle(vehicle);
	}

}
