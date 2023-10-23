package com.elorrieta.Grupo1.MyTube_Music.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.UserNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.User;
import com.elorrieta.Grupo1.MyTube_Music.model.UserPostRequest;
import com.elorrieta.Grupo1.MyTube_Music.model.UserServiceResponse;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<User> findAll() {
		return jdbcTemplate.query("select * from usuarios", BeanPropertyRowMapper.newInstance(User.class));
		 
	}

	@Override
	public User findById(int id) throws UserNotFoundException {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM usuarios WHERE id = ?", BeanPropertyRowMapper.newInstance(User.class), id);
		}  catch (EmptyResultDataAccessException e) {
			throw new UserNotFoundException(e.getMessage());
		}

		
	}

	@Override
	public int register(User user) {
		return jdbcTemplate.update("INSERT INTO usuarios (login, nombre, apellido, mail,contrasenya) VALUES (?,?,?,?,?)",
				new Object[] {user.getLogin(), user.getNombre(),user.getApellido(), user.getMail(), user.getContrasenya() });
	}
	

	@Override
	public int update(User user) {
		return jdbcTemplate.update("UPDATE usuarios SET  login=? ,nombre=?, apellido=?,mail=?,contrasenya = ? WHERE id = ?",
				new Object[] {user.getLogin(), user.getNombre(),user.getApellido(), user.getMail(), user.getContrasenya(), user.getId() });
	}
	
	@Override
	public int alterActive(int id) {
		return jdbcTemplate.update("UPDATE usuarios SET "
				+ "activo=0 WHERE id = ?", id);
	}

	
	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE FROM usuarios WHERE id = ?", id );
	}

	@Override
	public User loginUser(String login) {
			return jdbcTemplate.queryForObject("SELECT * FROM usuarios WHERE login = ?", BeanPropertyRowMapper.newInstance(User.class), login);
	
	}

	@Override
	public int alterLogin(int id, User user) {
		return jdbcTemplate.update("UPDATE usuarios set login = ? WHERE id = ?", new Object[] {user.getLogin(), id});
	}

	@Override
	public int changePass(int id, User user) {
		return jdbcTemplate.update("UPDATE usuarios set contrasenya = ? WHERE id = ?", new Object[] {user.getContrasenya(), id });
	}

}
