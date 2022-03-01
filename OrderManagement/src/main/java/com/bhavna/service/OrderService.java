package com.bhavna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.model.Orders;
import com.bhavna.repository.OrderRepository;
import com.bhavna.repository.ProductRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private ProductRepository productRepo;
	
	public List<Orders> getAllOrders(){
		return repo.findAll();
	}

	public Orders getOrder(Long orderId) {
		return repo.findById(orderId).orElseThrow();
	}

	public Orders postOrder(Orders order) {
		if(repo.findById(order.getId()).isPresent()) throw new RuntimeException("Order is present");
		order.setProduct(productRepo.findById(order.getProduct().getId()).orElseThrow());
		order.setCost(order.getQuantity()*order.getProduct().getPrice());
		return repo.save(order);
	}

	public Orders updateOrder(Orders order) {
		order.setProduct(productRepo.findById(order.getProduct().getId()).orElseThrow());
		order.setCost(order.getQuantity()*order.getProduct().getPrice());
		return repo.save(order);
	}

	public Orders patchOrder(Long orderId, Long productId, Integer quantity) {
		Orders order = repo.findById(orderId).orElseThrow();
		if(quantity!=null) order.setQuantity(quantity);
		if(productId!=null) order.setProduct(productRepo.findById(order.getProduct().getId()).orElseThrow());
		order.setCost(order.getQuantity()*order.getProduct().getPrice());
		return repo.save(order);
	}

	public void deleteOrder(Long orderId) {
		 repo.deleteById(orderId);
	}
	
	
}
