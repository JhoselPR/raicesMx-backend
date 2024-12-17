package com.raicesapi.raicesmx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	@PutMapping("/{id}")
	public ResponseEntity<Orders> updateOrder(@PathVariable("id") Integer id, @RequestBody Orders orders) {
		return orderService.findOrdersById(id).map(existingOrder -> {
			// Actualiza los campos de la order existente con los nuevos datos
			existingOrder.setDate_time(orders.getDate_time());
			existingOrder.setNotes(orders.getNotes());
			existingOrder.setQuantity(orders.getQuantity());
			existingOrder.setStatus(orders.getStatus());

			// Guarda la order actualizada
			Orders updateOrder = orderService.saveOrders(existingOrder);
			return ResponseEntity.ok(updateOrder);
		}).orElse(ResponseEntity.notFound().build()); // Si no se encuentra la orden, retorna 404
	}

}