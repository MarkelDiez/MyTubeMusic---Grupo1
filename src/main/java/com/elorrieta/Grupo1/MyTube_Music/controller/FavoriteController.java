package com.elorrieta.Grupo1.MyTube_Music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.elorrieta.Grupo1.MyTube_Music.model.SongServiceResponse;
import com.elorrieta.Grupo1.MyTube_Music.service.FavoriteService;

@RestController
public class FavoriteController {
	
	@Autowired
	FavoriteService favoriteService;
	
	@GetMapping("/api/favorite/{id}")
	public ResponseEntity<List<SongServiceResponse>> findFavoriteList(@PathVariable("id") Integer id){
		return new ResponseEntity<List<SongServiceResponse>>(favoriteService.findFavoriteList(id), HttpStatus.OK);
		
	}

}
