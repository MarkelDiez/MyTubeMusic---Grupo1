package com.elorrieta.Grupo1.MyTube_Music.service;

import java.util.List;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.UserNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.User;
import com.elorrieta.Grupo1.MyTube_Music.model.UserPostRequest;
import com.elorrieta.Grupo1.MyTube_Music.model.UserServiceResponse;

public interface UserService {

	List<UserServiceResponse> getAllUsers() throws UserNotFoundException;
	UserServiceResponse getUserById(int id)throws UserNotFoundException;
	UserServiceResponse getloginUser(String login)throws UserNotFoundException;
	int registerUser(User user);
	int updateUser(User user);
	int deleteByIdUser(int id);
	int alterActiveUser(int id);
	int alterLogin(int id, UserPostRequest userPostRequest);
	int changePass(int id, User user);
	
}
