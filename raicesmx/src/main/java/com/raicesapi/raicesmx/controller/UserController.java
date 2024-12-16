package com.raicesapi.raicesmx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raicesapi.raicesmx.models.User;
import com.raicesapi.raicesmx.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;

	// Get
	@GetMapping
	public List<User> getAllUsers() {
		return userService.findAllUsers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
		return userService.findUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	// Post
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	// PUT
	///////////////////

	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
		return userService.findUserById(id).map(user -> {
			userService.deleteUser(id);
			return ResponseEntity.ok().<Void>build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
