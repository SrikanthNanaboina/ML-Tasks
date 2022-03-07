package com.bhavna.hibernatedemo.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bhavna.hibernatedemo.entity.Owner;


@Repository
public class OwnerDaoImpl implements OwnerDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Owner getOwnerById(Integer id) {
		Session session = sessionFactory.openSession();
		Owner owner = session.get(Owner.class, id);
		session.close();
		return owner;
	}

	@Override
	public List<Owner> getOwners() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery < Owner > cq = cb.createQuery(Owner.class);
		Root<Owner> root = cq.from(Owner.class);
		cq.select(root);
		Query<Owner> query = session.createQuery(cq);
		List<Owner> owners = query.getResultList();
		session.close();
		return owners;
	}

	@Override
	public Owner saveOwner(Owner owner) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		owner.getVehicles().forEach(vehicle -> vehicle.setOwnerId(owner.getId()));
		session.save(owner);
		session.getTransaction().commit();
		session.close();
		return owner;
	}

	@Override
	public Owner updateOwner(Owner owner) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		owner.getVehicles().forEach(vehicle -> vehicle.setOwnerId(owner.getId()));
		session.saveOrUpdate(owner);
		session.getTransaction().commit();
		session.close();
		return owner;
	}

	
}
