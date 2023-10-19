package com.elorrieta.Grupo1.MyTube_Music.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.elorrieta.Grupo1.MyTube_Music.model.Song;

public class FavoriteRepositoryImpl implements FavoriteRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Song> findFavoriteList(Integer id) {
		return jdbcTemplate.query(
				"SELECT * FROM canciones c INNER JOIN favoritas f ON f.id_cancion = c.id WHERE id_usuario = ?",
				BeanPropertyRowMapper.newInstance(Song.class), id);
	}

}
