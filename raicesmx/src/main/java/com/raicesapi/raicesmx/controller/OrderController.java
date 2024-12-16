package com.raicesapi.raicesmx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raicesapi.raicesmx.models.Orders;
import com.raicesapi.raicesmx.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	// Get
	@GetMapping
	public List<Orders> getAllOrders() {
		return orderService.findAllOrders();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Orders> getOrderById(@PathVariable("id") Integer id) {
		return orderService.findOrdersById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	// Post
	@PostMapping
	public Orders createOrder(@RequestBody Orders order) {
		return orderService.saveOrders(order);
	}

	// PUT
	///////////////////

}
