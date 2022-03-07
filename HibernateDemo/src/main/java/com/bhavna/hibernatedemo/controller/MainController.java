package com.bhavna.hibernatedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.hibernatedemo.entity.Owner;
import com.bhavna.hibernatedemo.entity.Vehicle;
import com.bhavna.hibernatedemo.service.OwnerService;
import com.bhavna.hibernatedemo.service.VehicleService;

@RestController
public class MainController {
	@Autowired
	OwnerService ownerService;
	
	@Autowired
	VehicleService vehicleService;

	@GetMapping(value="/demo")
	public String demo() {
		return "Hello";
	}
	
	@GetMapping(value="get/owner/{id}")
	public Owner getOwnerById(@PathVariable Integer id) {
		return ownerService.getOwnerById(id);
	}
	
	@GetMapping(value="get/owners")
	public List<Owner> getOwners() {
		return ownerService.getOwners();
	}
	
	@PostMapping("/post/owner")
	public Owner postOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}
	
	@PutMapping("/update/owner")
	public Owner updateOwner(@RequestBody Owner owner) {
		return ownerService.updateOwner(owner);
	}
	
	@GetMapping(value="get/vehicle/{id}")
	public Vehicle getVehicleById(@PathVariable Integer id) {
		return vehicleService.getVehicleById(id);
	}
	
	@GetMapping(value="get/vehicles")
	public List<Vehicle> getVehicles() {
		return vehicleService.getVehicles();
	}
	
	@PostMapping("/post/vehicle")
	public Vehicle postVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.saveVehicle(vehicle);
	}
	
	@PutMapping("/update/vehicle")
	public Vehicle updateVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.updateVehicle(vehicle);
	}
}
