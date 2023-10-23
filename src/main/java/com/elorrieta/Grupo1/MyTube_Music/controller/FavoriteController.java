package com.elorrieta.Grupo1.MyTube_Music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.UserNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.Favorite;
import com.elorrieta.Grupo1.MyTube_Music.model.FavoritePostRequest;
import com.elorrieta.Grupo1.MyTube_Music.model.SongServiceResponse;
import com.elorrieta.Grupo1.MyTube_Music.service.FavoriteService;

@RestController
public class FavoriteController {
	
	@Autowired
	FavoriteService favoriteService;
	
	@GetMapping("/api/favorite/{id}")
	public ResponseEntity<List<SongServiceResponse>> findFavoriteList(@PathVariable("id") Integer id) throws UserNotFoundException{
		return new ResponseEntity<List<SongServiceResponse>>(favoriteService.findFavoriteList(id), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/api/favorite/{idUser}/{idSong}")
	public ResponseEntity<?> deleteFromFavorite(@PathVariable("idUser") Integer idUser,@PathVariable("idSong") Integer idSong){		
		return new ResponseEntity(favoriteService.deleteFromFavorite(idUser, idSong), HttpStatus.ACCEPTED);
	}

	@PostMapping("/api/favorite")
	public ResponseEntity<Integer> addFavoriteSong(@RequestBody FavoritePostRequest favoritePostrequest){
		Favorite favorite = new Favorite(favoritePostrequest.getId_usuario(), favoritePostrequest.getId_cancion());
		
		return new ResponseEntity<Integer>(favoriteService.addFavoriteSong(favorite), HttpStatus.CREATED);
	}
	
}
