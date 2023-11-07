package com.elorrieta.Grupo1.MyTube_Music.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.UserNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.User;
import com.elorrieta.Grupo1.MyTube_Music.model.UserPostRequest;
import com.elorrieta.Grupo1.MyTube_Music.model.UserServiceResponse;
import com.elorrieta.Grupo1.MyTube_Music.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	Scanner sc = new Scanner(System.in);

	@Override
	public List<UserServiceResponse> getAllUsers() throws UserNotFoundException {
		List<UserServiceResponse> response = new ArrayList<UserServiceResponse>();
		List<User> userList = userRepository.findAll();
		for (User user : userList) {
			System.out.println(user.getId());
			response.add(new UserServiceResponse(user.getId(), user.getLogin(), user.getNombre(), user.getApellido(),
					user.getMail(), user.getContrasenya(), user.isActivo()));
		}
		return response;
	}

	@Override
	public UserServiceResponse getUserById(int id) throws UserNotFoundException {
		User user = userRepository.findById(id);
		return new UserServiceResponse(user.getId(), user.getLogin(), user.getNombre(), user.getApellido(),
				user.getMail(), user.getContrasenya(), user.isActivo());
	}

	@Override
	public UserServiceResponse getloginUser(String login) throws UserNotFoundException {
		User user = userRepository.loginUser(login);
		return new UserServiceResponse(user.getId(), user.getLogin(), user.getNombre(), user.getApellido(),
				user.getMail(), user.getContrasenya(), user.isActivo());
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
	public int deleteByIdUser(int id) {
		return userRepository.deleteById(id);

	}

	@Override
	public int alterActiveUser(int id) {
		return userRepository.alterActive(id);
	}

	@Override
	public int alterLogin(int id, UserPostRequest userPostRequest) {
		UserServiceResponse userServiceResponse = null;
		try {
			userServiceResponse = getUserById(id);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		User userconvert = new User(id, userPostRequest.getLogin(), userServiceResponse.getNombre(),
				userServiceResponse.getApellido(), userServiceResponse.getMail(), userServiceResponse.getContrasenya(),
				userServiceResponse.isActivo());		
		return userRepository.alterLogin(id, userconvert);
	}

	@Override
	public int changePass(int id, User user) {
		UserServiceResponse userServiceResponse = null;
		try {
			userServiceResponse = getUserById(id);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		User userconvert = new User(id, userServiceResponse.getLogin(), userServiceResponse.getNombre(),
				userServiceResponse.getApellido(), userServiceResponse.getMail(), user.getContrasenya(),
				userServiceResponse.isActivo());
		return userRepository.changePass(id, userconvert);
	}

}
