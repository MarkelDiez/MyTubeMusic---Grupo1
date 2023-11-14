package com.elorrieta.Grupo1.MyTube_Music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
import com.elorrieta.Grupo1.MyTube_Music.model.User;
import com.elorrieta.Grupo1.MyTube_Music.service.FavoriteService;

@RestController
public class FavoriteController {
	
	@Autowired
	FavoriteService favoriteService;
	
	@GetMapping("/api/favorite")
	public ResponseEntity<List<SongServiceResponse>> findFavoriteList(Authentication authentication) throws UserNotFoundException{
		User userDetails = (User) authentication.getPrincipal();
		return new ResponseEntity<List<SongServiceResponse>>(favoriteService.findFavoriteList(userDetails.getId()), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/api/favorite/{idSong}")
	public ResponseEntity<?> deleteFromFavorite(@PathVariable("idSong") Integer idSong,Authentication authentication){	
		User userDetails = (User) authentication.getPrincipal();
		return new ResponseEntity(favoriteService.deleteFromFavorite(userDetails.getId(), idSong), HttpStatus.ACCEPTED);
	}

	@PostMapping("/api/favorite")
	public ResponseEntity<Integer> addFavoriteSong(@RequestBody FavoritePostRequest favoritePostrequest,Authentication authentication){
		User userDetails = (User) authentication.getPrincipal();
		Favorite favorite = new Favorite(userDetails.getId(), favoritePostrequest.getId_cancion());
		
		return new ResponseEntity<Integer>(favoriteService.addFavoriteSong(favorite), HttpStatus.CREATED);
	}
	
}
