package com.elorrieta.Grupo1.MyTube_Music.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.UserNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.Favorite;
import com.elorrieta.Grupo1.MyTube_Music.model.Song;
import com.elorrieta.Grupo1.MyTube_Music.model.SongServiceResponse;
import com.elorrieta.Grupo1.MyTube_Music.repository.FavoriteRepository;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	
	@Autowired
	FavoriteRepository favoriteRepository;

	@Override
	public List<SongServiceResponse> findFavoriteList(Integer id) throws UserNotFoundException{
		List<SongServiceResponse> response = new ArrayList<SongServiceResponse>();
		List<Song> favoriteSongList = favoriteRepository.findFavoriteList(id);
		for (Song song : favoriteSongList) {
			response.add(new SongServiceResponse(song.getId(), song.getTitulo(), song.getAutor(), song.getURL(), song.getImagen()));
		}
		return response;
	}

	@Override
	public int deleteFromFavorite(Integer idUser, Integer idSong) {
		return favoriteRepository.deleteFromFavorite(idUser, idSong);
	}

	@Override
	public int addFavoriteSong(Favorite favorite) {
		return favoriteRepository.addFavoriteSong(favorite);
	}

}
