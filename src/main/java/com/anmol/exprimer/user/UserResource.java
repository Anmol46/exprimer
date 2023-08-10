package com.anmol.exprimer.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.anmol.exprimer.blog.Blog;

@RestController
public class UserResource {

	private UserRepository userRepository;

	public UserResource(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/getUserById/{userid}")
	public User getUserById(@PathVariable UUID userid) {
		Optional<User> user = userRepository.findById(userid);

		if (user.isEmpty()) {
			throw new UserNotFoundException(userid);
		}

		else {
			return user.get();
		}
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/getUserBlogs/{userid}/blogs")
	public List<Blog> getUserBlogs(@PathVariable UUID userid) {

		Optional<User> user = userRepository.findById(userid);

		if (user.isEmpty()) {
			throw new UserNotFoundException(userid);
		}

		else {
			return user.get().getBlogs();
		}
	}

}
