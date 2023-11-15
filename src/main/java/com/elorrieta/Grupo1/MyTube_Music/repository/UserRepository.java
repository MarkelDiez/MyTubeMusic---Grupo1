package com.elorrieta.Grupo1.MyTube_Music.repository;

import java.util.Optional;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.UserNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.User;
import com.elorrieta.Grupo1.MyTube_Music.model.UserChangePass;

public interface UserRepository {

	//LOGIN
	Optional<User> findByLogin(String login);
	int create(User user);
	
	
//	List<User> findAll() throws UserNotFoundException;
	User findById(int id)throws UserNotFoundException;
//	int register(User user);
	int update(User user);
	int deleteById(int id);
//	User loginUser(String login)throws UserNotFoundException;
	int alterActive(int id);
	int alterLogin(int id, User userconvert);
	int changePass(int id, String password);
}
