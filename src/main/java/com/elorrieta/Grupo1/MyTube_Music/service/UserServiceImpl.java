package com.elorrieta.Grupo1.MyTube_Music.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.UserNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.User;
import com.elorrieta.Grupo1.MyTube_Music.model.UserServiceResponse;
import com.elorrieta.Grupo1.MyTube_Music.repository.UserRepository;

public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public List<UserServiceResponse> getAllUsers() throws UserNotFoundException {
		List<UserServiceResponse> response = new ArrayList<UserServiceResponse>();
		List<User> userList = userRepository.findAll();
		for (User user : userList) {
			response.add(new UserServiceResponse(user.getLogin(),user.getNombre(),user.getApellido(),user.getMail(),user.getContrasenya()));
		}
		return null;
	}

	@Override
	public UserServiceResponse getUserById(long id)throws UserNotFoundException {
		User user = userRepository.findById(id);
		return new UserServiceResponse(user.getLogin(),user.getNombre(),user.getApellido(),user.getMail(),user.getContrasenya());
	}

	@Override
	public UserServiceResponse getloginUser(String login)throws UserNotFoundException {
		User user = userRepository.loginUser(login);
		return new UserServiceResponse(user.getId(),user.getLogin(),user.getNombre(),user.getApellido(),user.getMail(),user.getContrasenya(),user.isActivo());
	}

	@Override
	public int registerUser(User user) {
		return userRepository.register(user);
	}

	@Override
	public int updateUser(User user) {
		return userRepository.register(user);
	}

	@Override
	public int deleteByIdUser(long id) {
		return userRepository.deleteById(id);

	}

	@Override
	public int alterActiveUser(User user) {
		return userRepository.alterActive(user);
	}

	@Override
	public int alterPasswordUser(User user) {
		return userRepository.alterPassword(user);
	}
	
	
}
