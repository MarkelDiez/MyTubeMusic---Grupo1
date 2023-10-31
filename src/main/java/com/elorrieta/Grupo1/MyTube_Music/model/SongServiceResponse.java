package com.elorrieta.Grupo1.MyTube_Music.model;

public class SongServiceResponse {
	
	private Integer id;
	private String titulo;
	private String autor;
	private String URL;
	private String imagen;
	
	
	public SongServiceResponse(Integer id, String titulo, String autor, String uRL, String imagen) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		URL = uRL;
		this.imagen = imagen;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "SongServiceResponse [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", URL=" + URL
				+ ", imagen=" + imagen + "]";
	}
	
	
	
}
