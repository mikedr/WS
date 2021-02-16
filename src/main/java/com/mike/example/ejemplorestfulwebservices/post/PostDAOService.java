package com.mike.example.ejemplorestfulwebservices.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PostDAOService {

	private static List<Post> posts = new ArrayList<Post>();
	
	private static int postCount = 6;
	
	static {
		posts.add(new Post(1,1,"Me encanta la 23"));
		posts.add(new Post(2,1,"Soy el León"));
		posts.add(new Post(3,2,"Soy el Principe"));
		posts.add(new Post(4,2,"Me cansé de romper redes"));
		posts.add(new Post(5,3,"Soy Napoleón"));
		posts.add(new Post(6,3,"Me pusieron Muñeco por Chuky"));
	}
	
	public List<Post> findAll() {
		return posts;
	}
	
	public List<Post> findAllPostsFromAUser(int userId) {
		List<Post> postsRetrieved = new ArrayList<Post>();
		for(Post post : posts) {
			if(userId == post.getUserId()) {
				postsRetrieved.add(post);
			}
		}
		return postsRetrieved;
	}
	
	public Post findAPostFromAUser(int userId, int id) {
		for(Post post : posts) {
			if(userId == post.getUserId()
					&& post.getId() == id) {
				return post;
			}
		}
		return null;
	}
	
	public Post savePost(Post post, int user_Id) {
		if(post.getId() == null) {
			post.setId(++postCount);
		}
		post.setUserId(user_Id);
		posts.add(post);
		return post;
	}
	
	public Post findOne(int id) {
		for(Post post : posts) {
			if(id == post.getId()) {
				return post;
			}
		}
		return null;
	}
}
