package com.bhavna.hibernatedemo.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="VEHICLES")
public class Vehicle implements Serializable{
	@Id
	@Column(name="V_ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="OWNER_ID")
	private Integer ownerId;
	

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

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + "]";
	}
	
	
}
