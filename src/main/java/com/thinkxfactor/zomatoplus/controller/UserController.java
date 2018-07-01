package com.thinkxfactor.zomatoplus.controller;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.zomatoplus.models.User;
import com.thinkxfactor.zomatoplus.repository.UserRepository;

class FieldEmptyException extends Exception {
	public String toString() {
		return "Username and/or Password field empty\n";
	}
}

@RestController
@RequestMapping("/user")  // class-level mapping
public class UserController {

	@Autowired 		// automatically creates objects for us (IoC)
	private UserRepository userRepository;
	
	// constructor injection is better
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		// takes user object from client
		User persistedUser = userRepository.save(user); 
		// line above saves the object in database
		// and returns same User object with id value updated as in DB  
		return persistedUser;
	}
	
	@GetMapping("/getAll")
	public List<User> getAll() {
		List <User> list_of_users = userRepository.findAll();
		return list_of_users;
	}
	
	@GetMapping("/getUser")
	public User getUser(@RequestParam("name") String username, @RequestParam("password") String password) {
		User persistedUser = userRepository.findByNameAndPassword(username, password);
		return persistedUser;
	}
	
	//same as above but post
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		User persistedUser = userRepository.findByNameAndPassword(user.getName(), user.getPassword());
		return persistedUser;
	}
	

	
	
//	List<User> users = new ArrayList<>();
	

//	@PostMapping("/login")
//	public Object userLogin(@RequestParam("name") String username, @RequestParam("password") String password) throws FieldEmptyException {
//		User usr = new User();
//		if (username.length() == 0 || password.length() == 0)
//			throw new FieldEmptyException();
//		usr.setName(username);
//		usr.setPassword(password);
//		return usr;
//	}
//	
//	@GetMapping("/all")
//	public List<User> userList() {
//		return users;
//	}
//	
//	@PostMapping("/create")
//	public User userCreate(@RequestBody User user) {
//		System.out.println(user.toString());
//		users.add(user);
//		return user;
//	}
}
