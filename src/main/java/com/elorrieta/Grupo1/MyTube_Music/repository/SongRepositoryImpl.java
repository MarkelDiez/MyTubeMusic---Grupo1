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

@Repository
public class SongRepositoryImpl implements SongRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Song> findAll(){
		try {
		return jdbcTemplate.query("SELECT * FROM canciones", BeanPropertyRowMapper.newInstance(Song.class));
		} catch(IncorrectResultSetColumnCountException e){
			return null;
		}
	}

	@Override
	public List<Song> findByTitle(String titulo) throws TitleNotFoundException {
			return jdbcTemplate.query("SELECT * FROM canciones WHERE titulo = ?", BeanPropertyRowMapper.newInstance(Song.class), titulo);
	}

	@Override
	public List<Song> findByAuthor(String autor) throws AuthorNotFoundException {
		return jdbcTemplate.query("SELECT * FROM canciones WHERE autor = ?", BeanPropertyRowMapper.newInstance(Song.class), autor);
	}
}
