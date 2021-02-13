package com.mike.example.ejemplorestfulwebservices.user;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {

	private static List<User> users = new ArrayList<User>();
	
	private static int userCount = 3;
	
	static {
		users.add(new User(1,"Leo", new Date()));
		users.add(new User(2,"Enzo", new Date()));
		users.add(new User(3,"Marcelo", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User SaveUser(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for (User user : users) {
			if(id == user.getId()) {
				return user;
			}
		}
		return null;
	}
}
