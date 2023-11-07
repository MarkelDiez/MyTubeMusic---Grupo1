package com.elorrieta.Grupo1.MyTube_Music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elorrieta.Grupo1.MyTube_Music.exceptions.UserNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.User;
import com.elorrieta.Grupo1.MyTube_Music.model.UserPostRequest;
import com.elorrieta.Grupo1.MyTube_Music.model.UserServiceResponse;
import com.elorrieta.Grupo1.MyTube_Music.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api")
public class UsersController {
	@Autowired
	UserService userService;

	@GetMapping("/user")
	public ResponseEntity<List<UserServiceResponse>> findAll() throws UserNotFoundException {
		return new ResponseEntity<List<UserServiceResponse>>(userService.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserServiceResponse> findById(@PathVariable int id) throws UserNotFoundException {
		return new ResponseEntity<UserServiceResponse>(userService.getUserById(id), HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<Integer> registerUser(@Valid @RequestBody UserPostRequest userPostRequest) {
		User user = new User(userPostRequest.getLogin(), userPostRequest.getNombre(), userPostRequest.getApellido(),
				userPostRequest.getMail(), userPostRequest.getContrasenya());
		return new ResponseEntity<Integer>(userService.registerUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/login/{login}")
	public ResponseEntity<UserServiceResponse> loginUser(@PathVariable String login) throws UserNotFoundException {
		return new ResponseEntity<UserServiceResponse>(userService.getloginUser(login), HttpStatus.OK);

	}

	@PutMapping("/active/{id}")
	public ResponseEntity<Integer> alterActive(@PathVariable("id") int id) {
		return new ResponseEntity<Integer>(userService.alterActiveUser(id), HttpStatus.OK);

	}
	
	@PutMapping("/password/{id}")
	public ResponseEntity<Integer> changePass(@PathVariable("id") int id, @RequestBody User user) {
		return new ResponseEntity<Integer>(userService.changePass(id, user), HttpStatus.OK);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<Integer> alterLogin(@PathVariable("id") int id, @RequestBody UserPostRequest userPostRequest) {
		return new ResponseEntity<Integer>(userService.alterLogin(id, userPostRequest), HttpStatus.OK);

	}

}
