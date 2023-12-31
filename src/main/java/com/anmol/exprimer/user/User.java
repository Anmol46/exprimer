package com.anmol.exprimer.user;

import java.util.List;
import java.util.UUID;

import com.anmol.exprimer.blog.Blog;
import com.anmol.exprimer.comment.Comment;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	private String firstname;
	
	private String lastname;
	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Blog> blogs;
	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Comment> comments;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}
	
	public List<Comment> getComment() {
		return comments;
	}

	public void setComment(List<Comment> comments) {
		this.comments = comments;
	}

	public User() {
		
	}
	
	public User(UUID id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
}
