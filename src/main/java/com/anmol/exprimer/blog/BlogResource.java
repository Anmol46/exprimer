package com.anmol.exprimer.blog;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogResource {

	private BlogRepository blogRepository;

	@GetMapping("/getBlog/{blogid}")
	public Blog getBlogById(@PathVariable UUID blogid) {
		Optional<Blog> blog = blogRepository.findById(blogid);

		if (blog.isEmpty()) {
			throw new BlogNotFoundException(blogid);
		}

		else {
			return blog.get();
		}
	}

	@GetMapping("/getAllBlogs")
	public List<Blog> getAllBlogs() {
		return blogRepository.findAll();
	}
}
