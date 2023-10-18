package com.elorrieta.Grupo1.MyTube_Music.repository;

import java.util.List;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.AuthorNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.exceptions.TitleNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.Song;

public interface SongRepository {

	List<Song> findAll();
	List<Song> findByTitle(String titulo) throws TitleNotFoundException;
	List<Song> findByAuthor(String autor) throws AuthorNotFoundException;
}
