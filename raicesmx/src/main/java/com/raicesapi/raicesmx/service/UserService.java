package com.raicesapi.raicesmx.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raicesapi.raicesmx.models.User;
import com.raicesapi.raicesmx.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	// Get
		public List<User> findAllUsers(){
			return userRepository.findAll();
		}
		
		public Optional<User> findUserById(Integer id){
			return userRepository.findById(id);
		}
		
		// Post
		public User saveUser(User user) {
			return userRepository.save(user);
		}
		
		// Put
		
		
		// Delete
		public void deleteUser(Integer id) {
			userRepository.deleteById(id);
		}
}
