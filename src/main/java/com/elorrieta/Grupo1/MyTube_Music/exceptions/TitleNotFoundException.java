package com.elorrieta.Grupo1.MyTube_Music.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Title not found")
public class TitleNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public TitleNotFoundException(String ErrorMessage) {
		super(ErrorMessage);
	}

}
