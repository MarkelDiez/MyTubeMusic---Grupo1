package com.elorrieta.Grupo1.MyTube_Music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.AuthorNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.exceptions.TitleNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.Song;
import com.elorrieta.Grupo1.MyTube_Music.repository.SongRepository;

@RestController
public class SongController {
	@Autowired
	SongRepository songRepository;
	
	@GetMapping("/api/songs")
	public ResponseEntity<List<Song>> findAll(){
		return new ResponseEntity<List<Song>>(songRepository.findAll(), HttpStatus.OK);
		
	}
	
	@GetMapping("/api/songs/title/{titulo}")
	public ResponseEntity<List<Song>> findByTitle(@PathVariable("titulo") String titulo) throws TitleNotFoundException{
	return new ResponseEntity<List<Song>>(songRepository.findByTitle(titulo),HttpStatus.OK);
	}
	
	@GetMapping("/api/songs/author/{id}")
	public ResponseEntity<List<Song>> findByAuthor(@PathVariable("autor") String autor) throws AuthorNotFoundException{
		return new ResponseEntity<List<Song>>(songRepository.findByAuthor(autor), HttpStatus.OK);
	}

}
