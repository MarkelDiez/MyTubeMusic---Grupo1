package com.elorrieta.Grupo1.MyTube_Music.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class SongNotFoundException {

	@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Song not found")
	public class TitleNotFoundException extends Exception {
		private static final long serialVersionUID = 1L;

		public TitleNotFoundException(String ErrorMessage) {
			super(ErrorMessage);
		}
	}
}
