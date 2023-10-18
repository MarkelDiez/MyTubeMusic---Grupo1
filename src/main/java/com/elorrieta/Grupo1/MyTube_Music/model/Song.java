package com.elorrieta.Grupo1.MyTube_Music.model;

public class Song {

	private Integer id;
	private String titulo;
	private String autor;
	private String URL;
	
	
	public Song(Integer id, String titulo, String autor, String uRL) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		URL = uRL;
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

	@Override
	public String toString() {
		return "Song [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", URL=" + URL + "]";
	}
	
	
}
