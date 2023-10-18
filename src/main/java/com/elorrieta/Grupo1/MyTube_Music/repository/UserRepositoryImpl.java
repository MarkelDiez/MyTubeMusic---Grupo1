package com.elorrieta.Grupo1.MyTube_Music.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.elorrieta.Grupo1.MyTube_Music.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<User> findAll() {
		jdbcTemplate.query("SELECT * FROM usuarios ", BeanPropertyRowMapper.newInstance(User.class));
		return null;
	}

	@Override
	public User findById(long id) {
		jdbcTemplate.query("SELECT * FROM usuarios WHERE id = ?", BeanPropertyRowMapper.newInstance(User.class), id);
		return null;
	}

	@Override
	public int register(User user) {
		return jdbcTemplate.update("INSERT INTO usuarios (login, nombre, apellido, mail,contrasenya) VALUES (?,?,?,?)",
				new Object[] {user.getLogin(), user.getNombre(),user.getApellido(), user.getMail(), user.getContrasenya() });
	}
	

	@Override
	public int update(User user) {
		return jdbcTemplate.update("UPDATE usuarios SET  login=? ,nombre=?, apellido=?,mail=?,contrasenya = ? WHERE id = ?",
				new Object[] {user.getLogin(), user.getNombre(),user.getApellido(), user.getMail(), user.getContrasenya(), user.getId() });
	}
	
	@Override
	public int alterActive(User user) {
		return jdbcTemplate.update("UPDATE usuarios SET "
				+ "activo=? WHERE id = ?",
				new Object[] {user.isActivo() });
	}
	@Override
	public int alterPassword(User user) {
		return jdbcTemplate.update("UPDATE usuarios SET "
				+ "contrasenya = ? WHERE id = ?",
				new Object[] {user.getContrasenya() });
	}

	
	@Override
	public int deleteById(long id) {
		return jdbcTemplate.update("DELETE DROM usuarios WHERE id = ?", id );
	}

	@Override
	public User loginUser(String login) {
		jdbcTemplate.query("SELECT * FROM usuarios WHERE login = ?", BeanPropertyRowMapper.newInstance(User.class), login);
		return null;
	}

}
