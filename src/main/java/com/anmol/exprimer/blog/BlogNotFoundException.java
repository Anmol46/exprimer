package com.anmol.exprimer.blog;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BlogNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BlogNotFoundException(UUID id) {
		super("Blog with " + id + " was not found");
	}

}
