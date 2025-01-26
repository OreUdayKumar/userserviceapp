
package com.userservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.entity.UserDetails;
import com.userservice.exception.custom.UserNotFoundException;
import com.userservice.service.UsersService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	private final UsersService usersService;

	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUsersDetailsById(@PathVariable Long id) {

		if (id == null) {
			throw new UserNotFoundException("User not found with id: " + id);
		}
		UserDetails userDetails = usersService.getUserDetailsById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
		return new ResponseEntity<>(userDetails, HttpStatus.CREATED);

	}

	@GetMapping
	public List<UserDetails> getUsers() {
		return usersService.getUsers();
	}

	@PostMapping
	public UserDetails save(@RequestBody UserDetails user) {
		return usersService.save(user);
	}

	@PutMapping
	public UserDetails update(@RequestBody UserDetails user) {
		return usersService.update(user);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		if (id == null) {
			throw new UserNotFoundException("User not found with id: " + id);
		}
		usersService.delete(id);
		return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	}
}
