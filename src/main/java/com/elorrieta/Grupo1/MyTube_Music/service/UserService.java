package com.elorrieta.Grupo1.MyTube_Music.service;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.UserNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.User;
import com.elorrieta.Grupo1.MyTube_Music.model.UserChangePass;
import com.elorrieta.Grupo1.MyTube_Music.model.UserServiceResponse;

public interface UserService {
	// login
	int create(User user);

	// List<UserServiceResponse> getAllUsers() throws UserNotFoundException;
	UserServiceResponse getUserById(int id) throws UserNotFoundException;

	// UserServiceResponse getloginUser(String login)throws UserNotFoundException;
//	int registerUser(User user);
	int updateUser(User user);

	int deleteByIdUser(int id);

	// int alterActiveUser(int id);
	// int alterLogin(int id, UserPostRequest userPostRequest);
	int changePass(User userDetails, UserChangePass user);

}
