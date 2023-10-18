package com.elorrieta.Grupo1.MyTube_Music.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.UserNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.User;
import com.elorrieta.Grupo1.MyTube_Music.repository.UserRepository;

public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() throws UserNotFoundException {
		List<User> response = new ArrayList<User>();
		List<User> userList = userRepository.findAll();
		for (User user : userList) {
			response.add(new User(user.getLogin(),user.getNombre(),user.getApellido(),user.getMail(),user.getContrasenya()));
		}
		return null;
	}

	@Override
	public User getUserById(long id)throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getloginUser(String login)throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByIdUser(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int alterActiveUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int alterPasswordUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
