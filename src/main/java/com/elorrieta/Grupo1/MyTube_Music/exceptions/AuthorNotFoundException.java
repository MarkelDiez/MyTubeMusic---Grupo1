package com.elorrieta.Grupo1.MyTube_Music.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Author not found")
public class AuthorNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public AuthorNotFoundException(String ErrorMessage) {
		super(ErrorMessage);
	}

}
