package com.project.OnlineVotingapp.rest;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.OnlineVotingapp.entity.User;
import com.project.OnlineVotingapp.service.Userserviceimp;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private Userserviceimp userService;

	public UserController(Userserviceimp userService) {
		super();
		this.userService = userService;
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id)
				.orElseThrow(() -> new NoSuchElementException("User not found with id " + id));

	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		userService.saveUser(user);
		return user;
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
		User user = userService.getUserById(id).orElseThrow(() -> new RuntimeException("User not found with id " + id));

		user.setUsername(updatedUser.getUsername());
		user.setPassword(updatedUser.getPassword());
		user.setEmail(updatedUser.getEmail());

		userService.saveUser(user);
		return user;
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}
