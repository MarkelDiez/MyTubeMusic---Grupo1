package com.elorrieta.Grupo1.MyTube_Music.repository;

import java.util.List;

import com.elorrieta.Grupo1.MyTube_Music.model.User;

public interface UserRepository {

	List<User> findAll();
	User findById(long id);
	int register(User user);
	int update(User user);
	int deleteById(long id);
	User loginUser(String login);
	int alterActive(User user);
	int alterPassword(User user);
}
