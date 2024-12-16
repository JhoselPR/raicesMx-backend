package com.raicesapi.raicesmx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raicesapi.raicesmx.models.Subscription;
import com.raicesapi.raicesmx.service.SubscriptionService;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {
	@Autowired
	private SubscriptionService subscriptionService;

	// Get
	@GetMapping
	public List<Subscription> getAllSubscriptions() {
		return subscriptionService.findAllSubscriptions();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Subscription> getSubscriptionById(@PathVariable("id") Integer id) {
		return subscriptionService.findSubscriptionById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

}
