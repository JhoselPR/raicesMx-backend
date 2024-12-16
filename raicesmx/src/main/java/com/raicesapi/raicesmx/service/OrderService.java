package com.raicesapi.raicesmx.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raicesapi.raicesmx.models.Orders;
import com.raicesapi.raicesmx.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	// Get
		public List<Orders> findAllOrders(){
			return orderRepository.findAll();
		}
		
		public Optional<Orders> findOrdersById(Integer id){
			return orderRepository.findById(id);
		}
		
		// Post
		public Orders saveOrders(Orders order) {
			return orderRepository.save(order);
		}
		
		// Put
		
		
		// Delete
		public void deleteOrders(Integer id) {
			orderRepository.deleteById(id);
		}
}
