package com.todoapp.toDoApplication.service;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.toDoApplication.entity.User;
import com.todoapp.toDoApplication.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User getUser(User user) {
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}

	public boolean getUserByUsername(String username, String password) {
		boolean isUsernamePresent;
		boolean isPasswordPresent;
		try {
			isUsernamePresent = userRepository.findTopByUsername(username) != null ? true : false;
			System.out.println("Username Present  ::" + isUsernamePresent);
			isPasswordPresent = userRepository.findTopByPassword(password) != null ? true : false;
			System.out.println("Password Present  ::" + isPasswordPresent);
		} catch (NonUniqueResultException nre) {
			return true;
		}
		return isUsernamePresent && isPasswordPresent;
	}

	public boolean findUserByUsername(String username) {
		boolean isUsernamePresent;
		try {
			isUsernamePresent = userRepository.findTopByUsername(username) != null ? true : false;
			System.out.println("Username Present  ::" + isUsernamePresent);
		} catch (NonUniqueResultException nre) {
			return true;
		}
		return isUsernamePresent;
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}


}
