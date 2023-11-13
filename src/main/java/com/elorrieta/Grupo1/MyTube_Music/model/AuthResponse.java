package com.elorrieta.Grupo1.MyTube_Music.model;

public class AuthResponse {
	private Integer id;
	private String contrasenya;
	private String login;
	private String accessToken;

	public AuthResponse() {
	}





	public AuthResponse(Integer id, String contrasenya, String login, String accessToken) {
		super();
		this.id = id;
		this.contrasenya = contrasenya;
		this.login = login;
		this.accessToken = accessToken;
	}
	public String getContrasenya() {
		return contrasenya;
	}



	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}