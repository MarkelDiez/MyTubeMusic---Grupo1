package com.elorrieta.Grupo1.MyTube_Music.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.AuthorNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.exceptions.TitleNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.Song;
import com.elorrieta.Grupo1.MyTube_Music.model.SongServiceResponse;
import com.elorrieta.Grupo1.MyTube_Music.repository.SongRepository;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	SongRepository songRepository;

	@Override
	public List<SongServiceResponse> findAll() {
		List<SongServiceResponse> response = new ArrayList<SongServiceResponse>();
		List<Song> songList = songRepository.findAll();
		for (Song song : songList) {
			response.add(new SongServiceResponse(song.getId(), song.getTitulo(), song.getAutor(), song.getURL()));
		}
		return response;
	}

	@Override
	public List<SongServiceResponse> findByTitle(String titulo) throws TitleNotFoundException {
		List<SongServiceResponse> response = new ArrayList<SongServiceResponse>();
		titulo = "%"+ titulo + "%";
		List<Song> songList = songRepository.findByTitle(titulo);
		for (Song song : songList) {
			response.add(new SongServiceResponse(song.getId(), song.getTitulo(), song.getAutor(), song.getURL()));
		}
		return response;
	}

	@Override
	public List<SongServiceResponse> findByAuthor(String autor) throws AuthorNotFoundException {
		List<SongServiceResponse> response = new ArrayList<SongServiceResponse>();
		autor = "%" + autor + "%";
		List<Song> songList = songRepository.findByAuthor(autor);
		for (Song song : songList) {
			response.add(new SongServiceResponse(song.getId(), song.getTitulo(), song.getAutor(), song.getURL()));
		}
		return response;
	}

	@Override
	public SongServiceResponse findById(int id) {
		Song song = songRepository.findById(id);
		return new SongServiceResponse(song.getId(), song.getTitulo(), song.getAutor(), song.getURL());
	}

	@Override
	public int create(Song song) {
		return songRepository.create(song);
	}

	@Override
	public int update(Song song) {
		return songRepository.update(song);
	}

	@Override
	public int deleteById(Integer id) {
		return songRepository.deleteById(id);
	}

}
