package com.test.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.demo.dto.CommentsDto;
import com.test.demo.dto.PostDto;
import com.test.demo.dto.UsersDto;
import com.test.demo.mapper.Mapper;
import com.test.demo.model.Comment;
import com.test.demo.model.PaginatedRequestPost;
import com.test.demo.model.PaginatedRequestUser;
import com.test.demo.model.Post;
import com.test.demo.util.model.ModelRequest;
import com.test.demo.util.model.ModelRequestComment;
import com.test.demo.util.model.ModelRequestPost;
import com.test.demo.util.model.PaginatedRequest;
import com.test.demo.util.model.User;

@Service
public class UserService {
	
	public List<UsersDto> getUser() {
		String uri = "https://gorest.co.in/public/v1/users";
		RestTemplate restTemplate = new RestTemplate();
		Mapper m= new Mapper();
		PaginatedRequestUser result =  restTemplate.getForObject(uri,PaginatedRequestUser.class);
		return result.getData().stream().map(r->m.toUsersDto(r)).collect(Collectors.toList());
	}
	
	public User getUser(int id) {
		String uri = "https://gorest.co.in/public/v1/users/"+id;
		RestTemplate restTemplate = new RestTemplate();
		ModelRequest result ;
try {
		 result = (ModelRequest) restTemplate.getForObject(uri,ModelRequest.class);
	}catch(Exception e) {
		return new User();
	}
		return (User) result.getData();
	}
	public List<PostDto> getPost() {
		String uri = "https://gorest.co.in/public/v1/posts";
		RestTemplate restTemplate = new RestTemplate();
		Mapper m= new Mapper();
		System.out.println(new PaginatedRequest<Post>().getClass());
		PaginatedRequestPost result = restTemplate.getForObject(uri,PaginatedRequestPost.class);
		return (List<PostDto>) result.getData().stream().map(r->m.toPostDto((Post) r)).collect(Collectors.toList());
	}
	public Post getPost(int id) {
		String uri = "https://gorest.co.in/public/v1/posts/"+id;
		RestTemplate restTemplate = new RestTemplate();
		ModelRequestPost result;
		try {
		 result = (ModelRequestPost) restTemplate.getForObject(uri,ModelRequestPost.class);
		}catch(Exception e) {
			return new Post();
		}
		return (Post) result.getData();
	}

	public List<User> getComments() {
		String uri = "https://gorest.co.in/public/v1/comments";
		RestTemplate restTemplate = new RestTemplate();

		PaginatedRequest result = (PaginatedRequest<Comment>) restTemplate.getForObject(uri,new PaginatedRequest<Comment>().getClass());
		return result.getData();
	}
	public Comment getComments(int id) {
		String uri = "https://gorest.co.in/public/v1/comments/"+id;
		RestTemplate restTemplate = new RestTemplate();
		ModelRequestComment result;
		try {
		result = (ModelRequestComment) restTemplate.getForObject(uri,ModelRequestComment.class);
		}catch(Exception e) {
			return new Comment();
		}
		return (Comment) result.getData();
		
	}

	public List<Comment> getCommentsforPost(int id) {
		String uri = "https://gorest.co.in/public/v1/posts/"+id+"/comments";
		RestTemplate restTemplate = new RestTemplate();

		PaginatedRequest result = (PaginatedRequest<Comment>) restTemplate.getForObject(uri,new PaginatedRequest<Comment>().getClass());
		return result.getData();
	}

	public List<PostDto> getPostForuser(int id) {
		String uri = "https://gorest.co.in/public/v1/users/"+id+"/posts";
		RestTemplate restTemplate = new RestTemplate();
		Mapper m= new Mapper();
	
		PaginatedRequestPost result = restTemplate.getForObject(uri,PaginatedRequestPost.class);
		return (List<PostDto>) result.getData().stream().map(r->m.toPostDto((Post) r)).collect(Collectors.toList());
	
	}

	public UsersDto getUserById(int i_id) {
		User user = getUser(i_id);
		return new Mapper().toUsersDto(user);

	}
	public PostDto getPostById(int i_id) {
		Post post = getPost(i_id);
		return new Mapper().toPostDto(post);

	}
	public CommentsDto getCommentById(int i_id) {
		Comment comment = getComments(i_id);
		return new Mapper().toCommentDto(comment);

	}
}
