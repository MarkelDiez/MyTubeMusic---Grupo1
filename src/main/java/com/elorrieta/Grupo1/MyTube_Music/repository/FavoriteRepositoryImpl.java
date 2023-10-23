package com.elorrieta.Grupo1.MyTube_Music.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.UserNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.Favorite;
import com.elorrieta.Grupo1.MyTube_Music.model.Song;

@Repository
public class FavoriteRepositoryImpl implements FavoriteRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Song> findFavoriteList(Integer id) throws UserNotFoundException {
		return jdbcTemplate.query(
				"SELECT c.id, c.titulo, c.autor, c.url FROM canciones c INNER JOIN favoritas f ON f.id_cancion = c.id WHERE id_usuario = ?",
				BeanPropertyRowMapper.newInstance(Song.class), id);
	}

	@Override
	public int deleteFromFavorite(Integer idUser, Integer idSong) {
		return jdbcTemplate.update("DELETE FROM favoritas WHERE id_usuario = ? and id_cancion = ?", idUser, idSong);
	}

	@Override
	public int addFavoriteSong(Favorite favorite) {
		return jdbcTemplate.update("INSERT INTO favoritas (id_usuario, id_cancion) VALUES (?,?)",
				new Object[] { favorite.getId_usuario(), favorite.getId_cancion() });
	}

}
