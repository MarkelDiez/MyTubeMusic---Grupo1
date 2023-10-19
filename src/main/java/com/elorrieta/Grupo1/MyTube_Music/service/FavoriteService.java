package com.elorrieta.Grupo1.MyTube_Music.service;

import java.util.List;

import com.elorrieta.Grupo1.MyTube_Music.model.SongServiceResponse;

public interface FavoriteService {
	
	List<SongServiceResponse>findFavoriteList(Integer id);

}
