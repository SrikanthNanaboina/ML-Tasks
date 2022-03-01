package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.model.Orders;
import com.bhavna.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService service;
	
	@GetMapping("/get/Orders")
	public List<Orders> getAllOrders() {
		return service.getAllOrders();
	}
	
	@GetMapping("/get/Order/{orderId}")
	public Orders getOrder(@PathVariable Long orderId) {
		return service.getOrder(orderId);
	}
	
	@PostMapping("/post/Order")
	public Orders postOrder(@RequestBody Orders order) {
		return service.postOrder(order);
	}
	
	@PutMapping("/update/Order")
	public Orders updateOrder(@RequestBody Orders order) {
		return service.updateOrder(order);
	}
	
	@PatchMapping("/update/Order/{orderId}")
	public Orders patchOrder(@PathVariable Long orderId, @RequestParam(name = "ProductId", required=false) Long productId,  @RequestParam(name = "Quantity", required=false) Integer quantity) {
		return service.patchOrder(orderId,productId,quantity);
	}
	
	@DeleteMapping("/delete/Order/{orderId}")
	public void deleteOrder(@PathVariable Long orderId) {
		service.deleteOrder(orderId);
	}
	
	@GetMapping("/demo")
	public String getDemo() {
		return "Hello";
	}
}
