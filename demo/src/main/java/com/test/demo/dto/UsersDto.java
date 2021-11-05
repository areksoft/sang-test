package com.test.demo.dto;

import java.util.List;

import com.test.demo.util.model.User;

public class UsersDto {
	User user;
	List<PostDto> posts;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<PostDto> getPosts() {
		return posts;
	}
	public void setPosts(List<PostDto> posts) {
		this.posts = posts;
	}
	
}
