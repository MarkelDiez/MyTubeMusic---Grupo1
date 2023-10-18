package com.elorrieta.Grupo1.MyTube_Music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.AuthorNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.exceptions.TitleNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.Song;
import com.elorrieta.Grupo1.MyTube_Music.model.SongPostRequest;
import com.elorrieta.Grupo1.MyTube_Music.model.SongServiceResponse;
import com.elorrieta.Grupo1.MyTube_Music.service.SongService;

@RestController
public class SongController {
	@Autowired
	SongService songService;

	@GetMapping("/api/songs")
	public ResponseEntity<List<SongServiceResponse>> findAll() {
		return new ResponseEntity<List<SongServiceResponse>>(songService.findAll(), HttpStatus.OK);

	}

	@GetMapping("/api/songs/title/{titulo}")
	public ResponseEntity<List<SongServiceResponse>> findByTitle(@PathVariable("titulo") String titulo)
			throws TitleNotFoundException {
		return new ResponseEntity<List<SongServiceResponse>>(songService.findByTitle(titulo), HttpStatus.OK);
	}

	@GetMapping("/api/songs/author/{autor}")
	public ResponseEntity<List<SongServiceResponse>> findByAuthor(@PathVariable("autor") String autor)
			throws AuthorNotFoundException {
		return new ResponseEntity<List<SongServiceResponse>>(songService.findByAuthor(autor), HttpStatus.OK);
	}

	@GetMapping("/api/song/{id}")
	public ResponseEntity<SongServiceResponse> findById(@PathVariable("id") int id) {
		return new ResponseEntity<SongServiceResponse>(songService.findById(id), HttpStatus.OK);
	}

	@PostMapping("/api/song")
	public ResponseEntity<Integer> createSong(@RequestBody SongPostRequest songPostRequest) {
		Song song = new Song(null, songPostRequest.getTitulo(), songPostRequest.getAutor(), songPostRequest.getURL());

		return new ResponseEntity<Integer>(songService.create(song), HttpStatus.CREATED);
	}

	@PutMapping("/api/song/{id}")
	public ResponseEntity updateSong(@PathVariable("id") Integer id, @RequestBody SongPostRequest songPostRequest) {
		Song song = new Song(id,songPostRequest.getTitulo(), songPostRequest.getAutor(), songPostRequest.getURL());
		
		return new ResponseEntity(songService.update(song), HttpStatus.CREATED);

	}
	
	@DeleteMapping("/api/song/{id}")
	public ResponseEntity deleteById(@PathVariable("id") Integer id) {
		return new ResponseEntity (songService.deleteById(id), HttpStatus.ACCEPTED);
		
	}

}
