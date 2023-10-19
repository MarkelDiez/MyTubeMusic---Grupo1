package com.elorrieta.Grupo1.MyTube_Music.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.AuthorNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.exceptions.TitleNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.Song;
import com.elorrieta.Grupo1.MyTube_Music.model.SongPostRequest;

@Repository
public class SongRepositoryImpl implements SongRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Song> findAll() {
		try {
			return jdbcTemplate.query("SELECT * FROM canciones", BeanPropertyRowMapper.newInstance(Song.class));
		} catch (IncorrectResultSetColumnCountException e) {
			return null;
		}
	}

	@Override
	public List<Song> findByTitle(String titulo) throws TitleNotFoundException {
		return jdbcTemplate.query("SELECT * FROM canciones WHERE titulo = ?",
				BeanPropertyRowMapper.newInstance(Song.class), titulo);
	}

	@Override
	public List<Song> findByAuthor(String autor) throws AuthorNotFoundException {
		return jdbcTemplate.query("SELECT * FROM canciones WHERE autor = ?",
				BeanPropertyRowMapper.newInstance(Song.class), autor);
	}

	@Override
	public Song findById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM canciones WHERE id = ?",
				BeanPropertyRowMapper.newInstance(Song.class), id);
	}

	@Override
	public int create(Song song) {
		return jdbcTemplate.update("INSERT INTO canciones (titulo, autor, url) VALUES (?, ?, ?)",
				new Object[] { song.getTitulo(), song.getAutor(), song.getURL() });
	}

	@Override
	public int update(Song song) {
		return jdbcTemplate.update(
		"UPDATE canciones SET titulo = ?, autor = ?, url = ? WHERE id = ?",
		new Object[] { song.getTitulo(), song.getAutor(), song.getURL(), song.getId() });
	}

	@Override
	public int deleteById(Integer id) {
		return jdbcTemplate.update(
				"DELETE FROM canciones WHERE id = ?", id);
	}
}
