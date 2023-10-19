package com.elorrieta.Grupo1.MyTube_Music.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserServiceResponse {

	private int id;
	@NotNull(message = "El campo login no puede ser nulo")
	@NotEmpty(message = "El campo login no puede estar vacio")
	@NotBlank(message = "El campo login no puede estar en blanco")
	private String login;
	@NotNull(message = "El campo nombre no puede ser nulo")
	@NotEmpty(message = "El campo nombre no puede estar vacio")
	@NotBlank(message = "El campo nombre no puede estar en blanco")
	private String nombre;
	@NotNull(message = "El campo apellido no puede ser nulo")
	@NotEmpty(message = "El campo apellido no puede estar vacio")
	@NotBlank(message = "El campo apellido no puede estar en blanco")
	private String apellido;
	@Email (message="Formato de mail incorrecto")
	private String mail;
	@NotNull(message = "El campo password no puede ser nulo")
	@NotEmpty(message = "El campo password no puede estar vacio")
	@NotBlank(message = "El campo password no puede estar en blanco")
	private String contrasenya;
	private boolean activo;

	public UserServiceResponse(int id,
			@NotNull(message = "El campo login no puede ser nulo") @NotEmpty(message = "El campo login no puede estar vacio") @NotBlank(message = "El campo login no puede estar en blanco") String login,
			@NotNull(message = "El campo nombre no puede ser nulo") @NotEmpty(message = "El campo nombre no puede estar vacio") @NotBlank(message = "El campo nombre no puede estar en blanco") String nombre,
			@NotNull(message = "El campo apellido no puede ser nulo") @NotEmpty(message = "El campo apellido no puede estar vacio") @NotBlank(message = "El campo apellido no puede estar en blanco") String apellido,
			@Email (message="Formato de mail incorrecto") String mail, 
			@NotNull(message = "El campo password no puede ser nulo") @NotEmpty(message = "El campo password no puede estar vacio")	@NotBlank(message = "El campo password no puede estar en blanco")String contrasenya, 
			boolean activo) {
		this.login = login;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.contrasenya = contrasenya;
		this.activo = activo;
	}
	public UserServiceResponse() {
		super();
	}
	public UserServiceResponse(
			@NotNull(message = "El campo login no puede ser nulo") @NotEmpty(message = "El campo login no puede estar vacio") @NotBlank(message = "El campo login no puede estar en blanco") String login,
			@NotNull(message = "El campo nombre no puede ser nulo") @NotEmpty(message = "El campo nombre no puede estar vacio") @NotBlank(message = "El campo nombre no puede estar en blanco") String nombre,
			@NotNull(message = "El campo apellido no puede ser nulo") @NotEmpty(message = "El campo apellido no puede estar vacio") @NotBlank(message = "El campo apellido no puede estar en blanco") String apellido,
			@Email (message="Formato de mail incorrecto") String mail, 
			@NotNull(message = "El campo password no puede ser nulo") @NotEmpty(message = "El campo password no puede estar vacio")	@NotBlank(message = "El campo password no puede estar en blanco")String contrasenya) {
		this.login = login;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.contrasenya = contrasenya;

	}



	public UserServiceResponse(String contrasenya) {
		this.contrasenya = contrasenya;
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

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", login=" + login + ", nombre=" + nombre + ", apellido=" + apellido + ", mail="
				+ mail + ", contrasenya=" + contrasenya + ", activo=" + activo + "]";
	}

}
