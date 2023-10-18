package com.elorrieta.Grupo1.MyTube_Music.model;

public class SongServiceResponse {
	
	private Integer id;
	private String titulo;
	private String autor;
	private String URL;
	
	
	public SongServiceResponse(Integer id, String titulo, String autor, String uRL) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		URL = uRL;
	}

	public SongServiceResponse() {
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
	
	
}
