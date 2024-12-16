package com.raicesapi.raicesmx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raicesapi.raicesmx.models.Diet;

@Repository
public interface DietRepository extends JpaRepository<Diet, Integer>{

}
