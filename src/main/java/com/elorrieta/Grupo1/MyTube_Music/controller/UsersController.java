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
import com.elorrieta.Grupo1.MyTube_Music.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api")
public class UsersController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/user")
	public ResponseEntity<List<User>> findAll() throws UserNotFoundException {
		return new ResponseEntity<List<User>>(userRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> findById(@PathVariable long id) throws UserNotFoundException {
		return new ResponseEntity<User>(userRepository.findById(id), HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<Integer> registerUser(@Valid @RequestBody UserPostRequest userPostRequest) {
		User user = new User(userPostRequest.getLogin(), userPostRequest.getNombre(), userPostRequest.getApellido(),
				userPostRequest.getMail(), userPostRequest.getContrasenya());
		return new ResponseEntity<Integer>(userRepository.register(user), HttpStatus.CREATED);
	}

	@GetMapping("/login/{login}")
	public ResponseEntity<User> loginUser(@PathVariable String login) throws UserNotFoundException {
		return new ResponseEntity<User>(userRepository.loginUser(login), HttpStatus.OK);

	}
	@PutMapping("/active/{id}")
	public ResponseEntity<Integer> alterActive(@PathVariable("id") long id,
			@Valid @RequestBody UserPostRequest userPostRequest) {
		User user = new User(userPostRequest.getContrasenya());
		return new ResponseEntity<Integer>(userRepository.alterActive(user), HttpStatus.OK);

	}
	

	@PutMapping("/password/{id}")
	public ResponseEntity<Integer> alterPassword(@PathVariable("id") long id,
			@Valid @RequestBody UserPostRequest userPostRequest) {
		User user = new User(userPostRequest.getContrasenya());
		return new ResponseEntity<Integer>(userRepository.alterPassword(user), HttpStatus.OK);

	}

}
