package com.bhavna.hibernatedemo.service;

import java.util.List;

import com.bhavna.hibernatedemo.entity.Owner;

public interface OwnerService {
	public Owner getOwnerById(Integer id);
	public List<Owner> getOwners();
	public Owner saveOwner(Owner owner);
	public Owner updateOwner(Owner owner);
}
