package com.anmol.exprimer.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anmol.exprimer.blog.Blog;
import com.anmol.exprimer.blog.BlogRepository;

@RestController
public class UserResource {
	
	private UserRepository userRepository;
	
	private BlogRepository blogRepository;
	
	public UserResource(UserRepository userRepository, BlogRepository blogRepository)
	{
		this.userRepository = userRepository;
		this.blogRepository = blogRepository;
	}
	
	@GetMapping("/getUserById")
	public User getUserById(UUID userid){
		Optional<User> user = userRepository.findById(userid);
		
		if(user.isEmpty()) {
			throw new UserNotFoundException(userid);
		}
		
		else {
			return user.get();
		}
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/getUserBlogs")
	public List<Blog> getUserBlogs(UUID userid){
		
		Optional<User> user = userRepository.findById(userid);
		
		if(user.isEmpty()) {
			throw new UserNotFoundException(userid);
		}
		
		else {
			return user.get().getBlogs();
		}
	}

}
