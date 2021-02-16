package com.mike.example.ejemplorestfulwebservices.post;

public class Post {

	private Integer id;
	
	private Integer userId;
	
	private String content;

	public Post(Integer id, Integer userId, String content) {
		super();
		this.id = id;
		this.userId = userId;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
