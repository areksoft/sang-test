package com.test.demo.mapper;

import org.springframework.stereotype.Component;

import com.test.demo.dto.CommentsDto;
import com.test.demo.dto.PostDto;
import com.test.demo.dto.UsersDto;
import com.test.demo.model.Comment;
import com.test.demo.model.Post;
import com.test.demo.service.UserService;
import com.test.demo.util.model.User;

@Component
public class Mapper {
//@Autowired 

public UsersDto toUsersDto(User user) {
	UsersDto usersDto = new UsersDto();
	UserService service = new UserService();
	int id = user.getId();
	usersDto.setPosts(service.getPostForuser(id));
	usersDto.setUser(user);
	return usersDto;
	
}
	public PostDto toPostDto(Post post) {
		UserService service = new UserService();
		PostDto postDto = new PostDto();
		postDto.setPost(post);
		postDto.setComments(service.getCommentsforPost(post.getId()));
		return postDto;
	}
	
	public CommentsDto toCommentDto(Comment comment) {
		CommentsDto dto = new CommentsDto();
			dto.setComment(comment);
			return dto;
		}
}
