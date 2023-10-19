package com.elorrieta.Grupo1.MyTube_Music.repository;

import java.util.List;

import com.elorrieta.Grupo1.MyTube_Music.model.Song;

public interface FavoriteRepository {

	List<Song> findFavoriteList(Integer id);

}
