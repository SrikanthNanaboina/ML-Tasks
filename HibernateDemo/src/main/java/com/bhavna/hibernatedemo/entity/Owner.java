package com.bhavna.hibernatedemo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="OWNERS")
public class Owner implements Serializable {
	
	@Id
	@Column(name="OWNER_ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(
//	            name="VEHICLES_OWNER",
//	            joinColumns = @JoinColumn( name="OWNER_ID"),
//	            inverseJoinColumns = @JoinColumn( name="V_ID")
//	    )
	@JoinColumn( name="OWNER_ID")
	private List<Vehicle> vehicles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", vehicles=" + vehicles + "]";
	}

	
}
