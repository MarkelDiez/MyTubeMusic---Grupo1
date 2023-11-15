package com.elorrieta.Grupo1.MyTube_Music.model;

public class UserChangePass {
	
	private int id;

	private String login;

	private String nombre;

	private String apellido;

	private String mail;
	
	private String contrasenyaOld;

	private String contrasenya;
	
	

	public UserChangePass(int id, String login, String nombre, String apellido, String mail, String contrasenyaOld,
			String contrasenya) {
		this.id = id;
		this.login = login;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.contrasenyaOld = contrasenyaOld;
		this.contrasenya = contrasenya;
	}
	
	public UserChangePass() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContrasenyaOld() {
		return contrasenyaOld;
	}

	public void setContrasenyaOld(String contrasenyaOld) {
		this.contrasenyaOld = contrasenyaOld;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	@Override
	public String toString() {
		return "UserChangePass [id=" + id + ", login=" + login + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", mail=" + mail + ", contrasenyaOld=" + contrasenyaOld + ", contrasenya=" + contrasenya + "]";
	}
	
	

}
