package com.elorrieta.Grupo1.MyTube_Music.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.UserNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.User;
import com.elorrieta.Grupo1.MyTube_Music.model.UserChangePass;
import com.elorrieta.Grupo1.MyTube_Music.model.UserServiceResponse;
import com.elorrieta.Grupo1.MyTube_Music.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	@Autowired
	UserRepository userRepository;

	Scanner sc = new Scanner(System.in);

//	@Override
//	public List<UserServiceResponse> getAllUsers() throws UserNotFoundException {
//		List<UserServiceResponse> response = new ArrayList<UserServiceResponse>();
//		List<User> userList = userRepository.findAll();
//		for (User user : userList) {
//			System.out.println(user.getId());
//			response.add(new UserServiceResponse(user.getId(), user.getLogin(), user.getNombre(), user.getApellido(),
//					user.getMail(), user.getContrasenya(), user.isActivo()));
//		}
//		return response;
//	}

	@Override
	public UserServiceResponse getUserById(int id) throws UserNotFoundException {
		User user = userRepository.findById(id);
		return new UserServiceResponse(user.getId(), user.getLogin(), user.getNombre(), user.getApellido(),
				user.getMail(), user.getContrasenya(), user.isActivo());
	}

//	@Override
//	public UserServiceResponse getloginUser(String login) throws UserNotFoundException {
//		User user = userRepository.loginUser(login);
//		return new UserServiceResponse(user.getId(), user.getLogin(), user.getNombre(), user.getApellido(),
//				user.getMail(), user.getContrasenya(), user.isActivo());
//	}

//	@Override
//	public int registerUser(User user) {
//		return userRepository.register(user);
//	}

	@Override
	public int updateUser(User user) {
		return userRepository.update(user);
	}

	@Override
	public int deleteByIdUser(int id) {
		return userRepository.deleteById(id);

	}

//	@Override
//	public int alterActiveUser(int id) {
//		return userRepository.alterActive(id);
//	}

//	@Override
//	public int alterLogin(int id, UserPostRequest userPostRequest) {
//		UserServiceResponse userServiceResponse = null;
//		try {
//			userServiceResponse = getUserById(id);
//		} catch (UserNotFoundException e) {
//			e.printStackTrace();
//		}
//		User userconvert = new User(id, userPostRequest.getLogin(), userServiceResponse.getNombre(),
//				userServiceResponse.getApellido(), userServiceResponse.getMail(), userServiceResponse.getContrasenya(),
//				userServiceResponse.isActivo());		
//		return userRepository.alterLogin(id, userconvert);
//	}

	@Override
	public int changePass(User userDetails, UserChangePass user) {
		UserServiceResponse userServiceResponse = null;
		try {
			userServiceResponse = getUserById(userDetails.getId());
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("UserFind " + userServiceResponse.getContrasenya());
		System.out.println("UserOld " + user.getContrasenyaOld());
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		boolean matches = bcrypt.matches(user.getContrasenyaOld(), userServiceResponse.getContrasenya());
		if (matches) {
			String password = bcrypt.encode(user.getContrasenya());
		return userRepository.changePass(userDetails.getId(), password);
		}
		return 0;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// esta es la funcion que busca al usuario por email.
		// ya que en este caso el campo de login es el email
		// si fuese otro, realizar otra funcion
		return userRepository.findByLogin(username)
				.orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));

	}

	@Override
	public int create(User user) {
		return userRepository.create(user);
	}

}
