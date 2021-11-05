package com.test.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.Service.JwtUserDetailsService;
import com.test.demo.dto.CommentsDto;
import com.test.demo.dto.PostDto;
import com.test.demo.dto.UsersDto;
import com.test.demo.service.UserService;
import com.test.demo.util.JwtTokenUtil;
import com.test.demo.util.model.JwtRequest;
import com.test.demo.util.model.JwtResponse;
import com.test.demo.util.model.User;

@RestController
public class ControllerMain {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
System.out.println(authenticationRequest);
	authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

	final UserDetails userDetails = userDetailsService
	.loadUserByUsername(authenticationRequest.getUsername());

	final String token = jwtTokenUtil.generateToken(userDetails);

	return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
	try {
	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	} catch (DisabledException e) {
	throw new Exception("USER_DISABLED", e);
	} catch (BadCredentialsException e) {
	throw new Exception("INVALID_CREDENTIALS", e);
	}
	}
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<UsersDto>> getUsers(){
		return new ResponseEntity<>(userService.getUser(),HttpStatus.OK); 
	}
	@GetMapping("/users/{id}")
	public ResponseEntity<UsersDto> getUsersById(@PathVariable("id") String id){
		int I_id = Integer.parseInt(id);
		return new ResponseEntity<>(userService.getUserById(I_id),HttpStatus.OK); 
	}
	@GetMapping("/posts/{id}")
	public ResponseEntity<PostDto> getPostsById(@PathVariable("id") String id){
		int I_id = Integer.parseInt(id);
		return new ResponseEntity<>(userService.getPostById(I_id),HttpStatus.OK); 
	}
	@GetMapping("/comments/{id}")
	public ResponseEntity<CommentsDto> getCommentsById(@PathVariable("id") String id){
		int I_id = Integer.parseInt(id);
		return new ResponseEntity<>(userService.getCommentById(I_id),HttpStatus.OK); 
	}
	
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>> getPosts(){
		return new ResponseEntity<>(userService.getPost(),HttpStatus.OK); 
	}
	@GetMapping("/comments")
	public ResponseEntity<List<User>> getComments(){
		return new ResponseEntity<>(userService.getComments(),HttpStatus.OK); 
	}
}
