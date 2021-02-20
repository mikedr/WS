package com.mike.example.ejemplorestfulwebservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@RestController
public class UserResource {

	@Autowired 
	UserDAOService userDAOService;
	
	@GetMapping(path = "/users/{id}")
	public Resource<User> getUser(@PathVariable int id) {
		User user = userDAOService.findOne(id);
		if(user == null) 
			throw new UserNotFoundException("id-"+id+" not found.");
	
		//HETEOAS
		Resource<User> resource = new Resource<User>(user); 
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAll()); 	//gracias al static import
		
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userDAOService.deleteById(id);
		if(user == null) 
			throw new UserNotFoundException("id-"+id+" not found.");
	}
	
	@GetMapping(path = "/users")
	public List<User> getAll() {
		return userDAOService.findAll();
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userDAOService.saveUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		System.out.println(location);
		
		return ResponseEntity.created(location).build();
	}
}
