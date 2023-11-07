package com.elorrieta.Grupo1.MyTube_Music.model;



import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotNull;

public class AuthRequest {
	@NotNull @Length(min = 4, max = 50)
	private String login;
	
	@NotNull @Length(min = 5, max = 10)
	private String contrasenya;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
	
}
