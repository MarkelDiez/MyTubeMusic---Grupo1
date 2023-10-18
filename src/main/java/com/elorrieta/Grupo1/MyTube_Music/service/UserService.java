package com.elorrieta.Grupo1.MyTube_Music.service;

import java.util.List;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.UserNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.User;

public interface UserService {

	List<User> getAllUsers() throws UserNotFoundException;
	User getUserById(long id)throws UserNotFoundException;
	User getloginUser(String login)throws UserNotFoundException;
	int registerUser(User user);
	int updateUser(User user);
	int deleteByIdUser(long id);
	int alterActiveUser(User user);
	int alterPasswordUser(User user);
	
}
