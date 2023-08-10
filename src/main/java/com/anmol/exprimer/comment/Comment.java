package com.anmol.exprimer.comment;

import com.anmol.exprimer.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity(name = "comment")
public class Comment {

	private String content;
	
	@OneToMany(fetch = FetchType.LAZY)
	private User user;
	
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
	
	public Comment(String content, User user) {
		this.content = content;
		this.user = user;
	}
}
