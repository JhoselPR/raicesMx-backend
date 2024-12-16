package com.raicesapi.raicesmx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raicesapi.raicesmx.models.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer>{

}
