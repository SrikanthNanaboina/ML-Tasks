package com.bhavna.hibernatedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.hibernatedemo.dao.OwnerDao;
import com.bhavna.hibernatedemo.entity.Owner;

@Service
public class OwnerServiceImpl implements OwnerService{
	@Autowired
	OwnerDao dao;

	@Override
	public Owner getOwnerById(Integer id) {
		return dao.getOwnerById(id);
	}

	@Override
	public List<Owner> getOwners() {
		return dao.getOwners();
	}

	@Override
	public Owner saveOwner(Owner owner) {
		return dao.saveOwner(owner);
	}

	@Override
	public Owner updateOwner(Owner owner) {
		return dao.updateOwner(owner);
	}

}
