package com.anmol.exprimer.comment;

import com.anmol.exprimer.blog.Blog;
import com.anmol.exprimer.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

@Entity(name = "comment")
public class Comment {

	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Blog blog;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Comment() {
		
	}
	
	public Comment(String content, User user, Blog blog) {
		this.content = content;
		this.user = user;
		this.blog = blog;
	}
}
