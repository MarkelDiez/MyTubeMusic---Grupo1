package com.elorrieta.Grupo1.MyTube_Music.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {

	private int id;

	private String login;

	private String nombre;

	private String apellido;

	private String mail;

	private String contrasenya;
	private boolean activo;

	public User(int id, String login, String nombre, String apellido, String mail, String contrasenya, boolean activo) {
		this.id = id;
		this.login = login;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.contrasenya = contrasenya;
		this.activo = activo;
	}

	public User() {
		super();
	}

	public User(String login, String nombre, String apellido, String mail, String contrasenya) {
		this.login = login;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.contrasenya = contrasenya;

	}

	public User(String contrasenya) {
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return contrasenya;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
