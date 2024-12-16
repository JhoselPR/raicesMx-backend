package com.raicesapi.raicesmx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
		return userService.findUserById(id).map(existingUser -> {
			// Actualiza los campos del usuario existente con los nuevos datos
			existingUser.setFirst_name(user.getFirst_name());
			existingUser.setLast_name(user.getLast_name());
			existingUser.setEmail(user.getEmail());  // Metodo Lombok getEmail()
			existingUser.setPassword(user.getPassword());
			existingUser.setBirthdate(user.getBirthdate());
			existingUser.setAddress(user.getAddress());
			existingUser.setPhone(user.getPhone());
			existingUser.setRole(user.getRole());

			// Guarda el usuario actualizado
			User updatedUser = userService.saveUser(existingUser);
			return ResponseEntity.ok(updatedUser); // Retorna el usuario actualizado
		}).orElse(ResponseEntity.notFound().build()); // Si no se encuentra el usuario, retorna 404
	}

	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
		return userService.findUserById(id).map(user -> {
			userService.deleteUser(id);
			return ResponseEntity.ok().<Void>build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
