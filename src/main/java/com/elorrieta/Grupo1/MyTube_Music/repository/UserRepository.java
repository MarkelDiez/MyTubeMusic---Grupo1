package com.elorrieta.Grupo1.MyTube_Music.repository;

import java.util.List;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.UserNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.User;
import com.elorrieta.Grupo1.MyTube_Music.model.UserPostRequest;
import com.elorrieta.Grupo1.MyTube_Music.model.UserServiceResponse;

public interface UserRepository {

	List<User> findAll() throws UserNotFoundException;
	User findById(int id)throws UserNotFoundException;
	int register(User user);
	int update(User user);
	int deleteById(int id);
	User loginUser(String login)throws UserNotFoundException;
	int alterActive(int id);
	int alterLogin(int id, User userconvert);
	int changePass(int id, User user);
}
