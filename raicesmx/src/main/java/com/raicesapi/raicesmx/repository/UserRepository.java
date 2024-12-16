package com.raicesapi.raicesmx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raicesapi.raicesmx.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
