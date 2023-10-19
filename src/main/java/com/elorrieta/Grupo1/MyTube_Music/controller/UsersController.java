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

import com.elorrieta.Grupo1.MyTube_Music.model.User;
import com.elorrieta.Grupo1.MyTube_Music.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api")
public class UsersController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/api/user")
	public ResponseEntity<List<User>> findAll() {
		return new ResponseEntity<List<User>>(userRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/api/user/{id}")
	public ResponseEntity<User> findById(@PathVariable long id)/* throws UserNotFoundException*/ {
		return new ResponseEntity<User>(userRepository.findById(id), HttpStatus.OK);
	}

	@PostMapping("/api/register")
	public ResponseEntity<Integer> registerUser(@Valid @RequestBody User userRequest) {
		User user = new User(userRequest.getLogin(), userRequest.getNombre(), userRequest.getApellido(),
				userRequest.getMail(), userRequest.getContrasenya());
		return new ResponseEntity<Integer>(userRepository.register(user), HttpStatus.CREATED);
	}

	@GetMapping("/api/login/{login}")
	public ResponseEntity<User> loginUser(@PathVariable String login) {
		return new ResponseEntity<User>(userRepository.loginUser(login), HttpStatus.OK);

	}

	@PutMapping("/api/password/{id}")
	public ResponseEntity<Integer> updateEmployee(@PathVariable("id") long id,
			@Valid @RequestBody User userPostRequest) {
		User user = new User(userPostRequest.getContrasenya());
		return new ResponseEntity<Integer>(userRepository.alterPassword(user), HttpStatus.OK);

	}

}
