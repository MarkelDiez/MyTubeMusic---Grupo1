package com.elorrieta.Grupo1.MyTube_Music.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Song {

	private Integer id;
	@NotNull(message = "El campo titulo no puede ser nulo")
	@NotEmpty(message = "El campo titulo no puede estar vacio")
	@NotBlank(message = "El campo titulo no puede estar en blanco")
	private String titulo;
	@NotNull(message = "El campo autor no puede ser nulo")
	@NotEmpty(message = "El campo autor no puede estar vacio")
	@NotBlank(message = "El campo autor no puede estar en blanco")
	private String autor;
	@NotNull(message = "El campo URL no puede ser nulo")
	@NotEmpty(message = "El campo URL no puede estar vacio")
	@NotBlank(message = "El campo URL no puede estar en blanco")
	private String URL;
	@NotNull(message = "El campo URL no puede ser nulo")
	@NotEmpty(message = "El campo URL no puede estar vacio")
	@NotBlank(message = "El campo URL no puede estar en blanco")
	private String imagen;

	public Song(int id,
			@NotNull(message = "El campo titulo no puede ser nulo") @NotEmpty(message = "El campo titulo no puede estar vacio") @NotBlank(message = "El campo titulo no puede estar en blanco") String titulo,
			@NotNull(message = "El campo autor no puede ser nulo") @NotEmpty(message = "El campo autor no puede estar vacio") @NotBlank(message = "El campo autor no puede estar en blanco") String autor,
			@NotNull(message = "El campo URL no puede ser nulo") @NotEmpty(message = "El campo URL no puede estar vacio") @NotBlank(message = "El campo URL no puede estar en blanco") String uRL,
			@NotNull(message = "El campo URL no puede ser nulo") @NotEmpty(message = "El campo URL no puede estar vacio") @NotBlank(message = "El campo URL no puede estar en blanco") String imagen) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		URL = uRL;
		this.imagen = imagen;
	}

	public Song(
			@NotNull(message = "El campo titulo no puede ser nulo") @NotEmpty(message = "El campo titulo no puede estar vacio") @NotBlank(message = "El campo titulo no puede estar en blanco") String titulo,
			@NotNull(message = "El campo autor no puede ser nulo") @NotEmpty(message = "El campo autor no puede estar vacio") @NotBlank(message = "El campo autor no puede estar en blanco") String autor,
			@NotNull(message = "El campo URL no puede ser nulo") @NotEmpty(message = "El campo URL no puede estar vacio") @NotBlank(message = "El campo URL no puede estar en blanco") String uRL,
			@NotNull(message = "El campo URL no puede ser nulo") @NotEmpty(message = "El campo URL no puede estar vacio") @NotBlank(message = "El campo URL no puede estar en blanco") String imagen) {
		this.titulo = titulo;
		this.autor = autor;
		URL = uRL;
		this.imagen = imagen;
	}

	public Song() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", URL=" + URL + ", imagen=" + imagen
				+ "]";
	}



}
