package com.todoapp.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.todoapp.toDoApplication.entity.User;
import com.todoapp.toDoApplication.service.UserService;

@SpringBootTest
@ActiveProfiles("test")
public class UserControllerTests {

	@Mock
	private UserService userServiceTest;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	User userTest = new User(1, "TestUsername", "TestPassword");

	@Test
	public void getCurrentUserTest() {
		Mockito.when(userServiceTest.getUser(Mockito.any())).thenReturn(userTest);
	}

	@Test
	public void findUserByUsernameTest() {
		Mockito.when(userServiceTest.getUserByUsername(Mockito.any(), Mockito.any())).thenReturn(true);
	}

	@Test
	public void addUserTest() {
		Mockito.when(userServiceTest.findUserByUsername(Mockito.any())).thenReturn(true);
		Mockito.doNothing().when(userServiceTest).saveUser(Mockito.any());
	}

}
