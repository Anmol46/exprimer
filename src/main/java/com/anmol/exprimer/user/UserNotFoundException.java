package com.anmol.exprimer.user;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(UUID id) {

		super("User with " + id + " is not found");
	}
}
