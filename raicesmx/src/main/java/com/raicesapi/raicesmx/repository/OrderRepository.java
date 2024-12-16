package com.raicesapi.raicesmx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raicesapi.raicesmx.models.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
