package com.elorrieta.Grupo1.MyTube_Music.repository;

import java.util.List;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.UserNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.Song;

public interface FavoriteRepository {

	List<Song> findFavoriteList(Integer id) throws UserNotFoundException;

	int deleteFromFavorite(Integer idUser, Integer idSong);

	Integer addFavoriteSong(Integer idUser, Integer idSong);

}
