package com.elorrieta.Grupo1.MyTube_Music.service;

import java.util.List;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.AuthorNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.exceptions.TitleNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.Song;
import com.elorrieta.Grupo1.MyTube_Music.model.SongServiceResponse;

public interface SongService {
	
	List<SongServiceResponse> findAll();
	List<SongServiceResponse> findByTitle(String titulo) throws TitleNotFoundException;
	List<SongServiceResponse> findByAuthor(String autor) throws AuthorNotFoundException;
	SongServiceResponse findById(int id);
	int create(Song song);
	int update(Song song);
	int deleteById(Integer id);

}
