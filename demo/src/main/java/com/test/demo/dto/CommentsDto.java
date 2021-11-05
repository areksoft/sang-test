package com.test.demo.dto;

import com.test.demo.model.Comment;
import com.test.demo.model.Post;
import com.test.demo.util.model.User;

public class CommentsDto {
	Comment comment;

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}


}
