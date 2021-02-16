package com.mike.example.ejemplorestfulwebservices.post;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mike.example.ejemplorestfulwebservices.user.User;

@RestController
public class PostResource {

	@Autowired
	PostDAOService postDAOService;
	
	@GetMapping(path = "/users/{id}/posts")
	public List<Post> getPostsFromUser(@PathVariable int id) {
		return postDAOService.findAllPostsFromAUser(id);
	}
	
	@GetMapping(path = "/users/{user_id}/posts/{post_id}")
	public Post getPostFromUser(@PathVariable int user_id, 
			@PathVariable int post_id) {
		Post restrievedPost = postDAOService.findAPostFromAUser(user_id,post_id);
		if(restrievedPost == null)
			throw new PostNotFoundException("User id: "+user_id+" Post id: "+post_id+" no corresponden a ningun post");
		return restrievedPost;
	}
	
	@PostMapping(path = "/users/{user_id}/posts")
	public ResponseEntity<Object> createPostForUser(@RequestBody Post post, 
			@PathVariable Integer user_id) {
		Post savedPost = postDAOService.savePost(post, user_id);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(savedPost.getId()).toUri();
		
		System.out.println(location);
		
		return ResponseEntity.created(location).build();
	}
}
