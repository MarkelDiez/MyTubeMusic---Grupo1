package com.elorrieta.Grupo1.MyTube_Music.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Favorite {

	@NotNull(message = "El campo id_usuario no puede ser nulo")
	@NotEmpty(message = "El campo id_usuario no puede estar vacio")
	@NotBlank(message = "El campo id_usuario no puede estar en blanco")
	private int id_usuario;
	@NotNull(message = "El campo id_cancion no puede ser nulo")
	@NotEmpty(message = "El campo id_cancion no puede estar vacio")
	@NotBlank(message = "El campo id_cancion no puede estar en blanco")
	private int id_cancion;

	public Favorite(
			@NotNull(message = "El campo id_usuario no puede ser nulo") @NotEmpty(message = "El campo id_usuario no puede estar vacio") @NotBlank(message = "El campo id_usuario no puede estar en blanco") int id_usuario,
			@NotNull(message = "El campo id_cancion no puede ser nulo") @NotEmpty(message = "El campo id_cancion no puede estar vacio") @NotBlank(message = "El campo id_cancion no puede estar en blanco") int id_cancion) {
		this.id_usuario = id_usuario;
		this.id_cancion = id_cancion;
	}

	public Favorite() {
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_cancion() {
		return id_cancion;
	}

	public void setId_cancion(int id_cancion) {
		this.id_cancion = id_cancion;
	}

	@Override
	public String toString() {
		return "Favoritas [id_usuario=" + id_usuario + ", id_cancion=" + id_cancion + "]";
	}
}
