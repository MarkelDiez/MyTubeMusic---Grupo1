package com.elorrieta.Grupo1.MyTube_Music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elorrieta.Grupo1.MyTube_Music.configuration.JwtTokenUtil;
import com.elorrieta.Grupo1.MyTube_Music.exceptions.UserNotFoundException;
import com.elorrieta.Grupo1.MyTube_Music.model.AuthRequest;
import com.elorrieta.Grupo1.MyTube_Music.model.AuthResponse;
import com.elorrieta.Grupo1.MyTube_Music.model.User;
import com.elorrieta.Grupo1.MyTube_Music.model.UserPostRequest;
import com.elorrieta.Grupo1.MyTube_Music.model.UserServiceResponse;
import com.elorrieta.Grupo1.MyTube_Music.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api")
public class UsersController {
	
	@Autowired 
	AuthenticationManager authenticationManager;
	
	@Autowired 
	JwtTokenUtil jwtUtil;
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/user/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		try {
			System.out.println(request.getLogin());
			System.out.println(request.getContrasenya());
			// esta es la funcion que va a intentar identificarse, dado el username y la password introducida
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getLogin(), request.getContrasenya())
			); 
			// devolvera un objeto de tipo authenticacion de las que de momento nos interesa el "principal". El principal contiene los datos del usuario
			// por lo que lo convertimos a su modelo real de BD para tener todos sus campos
			User user = (User) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(user);

			System.out.println(user.getId()+" "+user.getContrasenya()+" "+user.getLogin()+" "+ accessToken);
			AuthResponse response = new AuthResponse(user.getId(),user.getContrasenya(),user.getLogin(), accessToken);
			
			return ResponseEntity.ok().body(response);
			
		} catch (BadCredentialsException ex) {
			// esta excepción salta y estamos devolviendo un 401. se podria cambiar pero cuidado con lo que se devuelve al fallar el login etc
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@PostMapping("/user/signup")
	public ResponseEntity<?> signIn(@RequestBody @Valid UserPostRequest request) {
		// TODO solo esta creado en el caso de que funcione. Si no es posible que de 500 o 401.
		// aqui hacer lo que sea preciso

		// vamos a cifrar la contrasenia aqui, ya que no queremos andar dando vueltas con la contraseña sin encriptar si no es preciso
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode(request.getContrasenya());
		
		// creamos el usuario en DB
		User user = new User(request.getLogin(),request.getNombre(),request.getApellido(),request.getMail(), password);
		return new ResponseEntity<Integer>(userService.create(user), HttpStatus.CREATED);
	}
	
	// utilizamos el /me por que vamos a coger el nuestro, el que estamos logueado...
	@GetMapping("/user/me")
	public ResponseEntity<?> getUserInfo(Authentication authentication) {
		// aqui podemos castearlo a UserDetails o User. El UserDetails es una interfaz, 
		// si lo casteamos a la interfaz no podremos sacar campos como la ID del usuario
		User userDetails = (User) authentication.getPrincipal();
		
		// IMPORTANTE: por lo tanto, la ID del usuario no tiene que ir como parametro en la peticion del usuario
		
		// aqui podriamos devolver datos del usuario. quizá no sea lo que queremos devolver o no lo querramos devolver
		// es un ejemplo por que con userDetails.getId() tendríamos la ID del usuario sin que la pase por parametro
		// necesario en algunos servicios: si quiero devolver una lista o elemento privado del usuario, no voy a querer
		// que el usuario mande su ID por parametro. Ya que es trampeable.
		// de ahi que sea "/me" en el ejemplo 
		
		return ResponseEntity.ok().body(userDetails);
	}
	
	
	
	

//	@GetMapping("/user")
//	public ResponseEntity<List<UserServiceResponse>> findAll() throws UserNotFoundException {
//		return new ResponseEntity<List<UserServiceResponse>>(userService.getAllUsers(), HttpStatus.OK);
//	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserServiceResponse> findById(@PathVariable int id) throws UserNotFoundException {
		return new ResponseEntity<UserServiceResponse>(userService.getUserById(id), HttpStatus.OK);
	}

//	@PostMapping("/register")
//	public ResponseEntity<Integer> registerUser(@Valid @RequestBody UserPostRequest userPostRequest) {
//		User user = new User(userPostRequest.getLogin(), userPostRequest.getNombre(), userPostRequest.getApellido(),
//				userPostRequest.getMail(), userPostRequest.getContrasenya());
//		return new ResponseEntity<Integer>(userService.registerUser(user), HttpStatus.CREATED);
//	}

//	@GetMapping("/login/{login}")
//	public ResponseEntity<UserServiceResponse> loginUser(@PathVariable String login) throws UserNotFoundException {
//		return new ResponseEntity<UserServiceResponse>(userService.getloginUser(login), HttpStatus.OK);
//
//	}

//	@PutMapping("/active/{id}")
//	public ResponseEntity<Integer> alterActive(@PathVariable("id") int id) {
//		return new ResponseEntity<Integer>(userService.alterActiveUser(id), HttpStatus.OK);
//
//	}
	
	@PutMapping("/password/{id}")
	public ResponseEntity<Integer> changePass(@PathVariable("id") int id, @RequestBody User user) {
		return new ResponseEntity<Integer>(userService.changePass(id, user), HttpStatus.OK);
	}

//	@PutMapping("/user/{id}")
//	public ResponseEntity<Integer> alterLogin(@PathVariable("id") int id, @RequestBody UserPostRequest userPostRequest) {
//		return new ResponseEntity<Integer>(userService.alterLogin(id, userPostRequest), HttpStatus.OK);
//
//	}

}
