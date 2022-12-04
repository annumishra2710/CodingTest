package com.todoapp.toDoApplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.toDoApplication.service.UserService;

import com.todoapp.toDoApplication.entity.User;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/getUserInfo")
	private User getCurrentUser(@RequestBody User user) {
		logger.info("Get user by username ****");
		return userService.getUser(user);
	}
	
	@GetMapping("/getUserByUsername/{username}/{password}")
	private boolean findUserByUsername(@PathVariable String username, @PathVariable String password) {
		logger.info("Get user by username and Password ****");
		return userService.getUserByUsername(username, password);
	}

	@PostMapping("/createUser")
	private boolean addUser(@RequestBody User user){
		boolean doesUserExist = userService.findUserByUsername(user.getUsername());
		if(doesUserExist){
			logger.info("User already exist.Cant create this user");
			return false;
		}
		userService.saveUser(user);
		return true;
	}


}
