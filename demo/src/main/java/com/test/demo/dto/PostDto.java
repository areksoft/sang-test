package com.test.demo.dto;

import java.util.List;

import com.test.demo.model.Comment;
import com.test.demo.model.Post;
import com.test.demo.util.model.User;

public class PostDto {
//	User user;
	Post post;
	List<Comment> comments;

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	

}
