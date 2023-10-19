package com.elorrieta.Grupo1.MyTube_Music.repository;

import java.util.List;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.UserNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.User;

public interface UserRepository {

	List<User> findAll() throws UserNotFoundException;
	User findById(long id)throws UserNotFoundException;
	int register(User user);
	int update(User user);
	int deleteById(long id);
	User loginUser(String login)throws UserNotFoundException;
	int alterActive(User user);
	int alterPassword(User user);
}
