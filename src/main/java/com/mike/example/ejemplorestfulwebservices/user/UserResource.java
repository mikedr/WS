package com.mike.example.ejemplorestfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired 
	UserDAOService userDAOService;
	
	@GetMapping(path = "/users/{id}")
	public User getUser(@PathVariable int id) {
		return userDAOService.findOne(id);
	}
	
	@GetMapping(path = "/users")
	public List<User> getAll() {
		return userDAOService.findAll();
	}
	
	@PostMapping(path = "/users")
	public void createUser(@RequestBody User user) {
		User savedUser = userDAOService.saveUser(user);
	}
}
