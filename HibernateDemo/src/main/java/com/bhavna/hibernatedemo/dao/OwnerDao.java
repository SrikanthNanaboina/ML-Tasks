package com.bhavna.hibernatedemo.dao;

import java.util.List;

import com.bhavna.hibernatedemo.entity.Owner;

public interface OwnerDao {
	public Owner getOwnerById(Integer id);
	public List<Owner> getOwners();
	public Owner saveOwner(Owner owner);
	public Owner updateOwner(Owner owner);
}
