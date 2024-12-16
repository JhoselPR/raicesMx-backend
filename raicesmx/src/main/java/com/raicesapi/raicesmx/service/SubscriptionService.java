package com.raicesapi.raicesmx.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raicesapi.raicesmx.models.Subscription;
import com.raicesapi.raicesmx.repository.SubscriptionRepository;

@Service
public class SubscriptionService {
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	// Get
		public List<Subscription> findAllSubscriptions(){
			return subscriptionRepository.findAll();
		}
		
		public Optional<Subscription> findSubscriptionById(Integer id){
			return subscriptionRepository.findById(id);
		}
		
		// Post
		public Subscription saveSubscription(Subscription subscription) {
			return subscriptionRepository.save(subscription);
		}
		
		// Put
		
		
		// Delete
		public void deleteSubscription(Integer id) {
			subscriptionRepository.deleteById(id);
		}
}
