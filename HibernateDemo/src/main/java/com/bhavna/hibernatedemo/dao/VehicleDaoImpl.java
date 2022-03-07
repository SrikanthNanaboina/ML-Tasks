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

import com.bhavna.hibernatedemo.entity.Vehicle;

@Repository
public class VehicleDaoImpl implements VehicleDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Vehicle getVehicleById(Integer id) {
		Session session = sessionFactory.openSession();
		Vehicle vehicle = session.get(Vehicle.class, id);
		session.close();
		return vehicle;
	}

	@Override
	public List<Vehicle> getVehicles() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Vehicle> cq = cb.createQuery(Vehicle.class);
		Root<Vehicle> root = cq.from(Vehicle.class);
		cq.select(root);
		Query<Vehicle> query = session.createQuery(cq);
		List<Vehicle> vehicles = query.getResultList();
		session.close();
		return vehicles;

	}

	@Override
	public Vehicle saveVehicle(Vehicle vehicle) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
		return vehicle;
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(vehicle);
		session.getTransaction().commit();
		session.close();
		return vehicle;
	}
	
}
