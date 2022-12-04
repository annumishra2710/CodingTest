package com.todoapp.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.todoapp.toDoApplication.entity.User;
import com.todoapp.toDoApplication.repository.UserRepository;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTests {
	
	@Mock
	private UserRepository userRepositoryTest;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	User userTest = new User(1, "TestUsername", "TestPassword");
	
	@Test
	public void getUserTest(){
		Mockito.when(userRepositoryTest.findByUsernameAndPassword(Mockito.any(),Mockito.any())).thenReturn(userTest);
	}

	@Test
	public void getUserByUsernameTest(){
		Mockito.when(userRepositoryTest.findTopByUsername(Mockito.any())).thenReturn(userTest);
		Mockito.when(userRepositoryTest.findTopByPassword(Mockito.any())).thenReturn(userTest);
	}
	
	@Test
	public void findUserByUsernameTest(){
		Mockito.when(userRepositoryTest.findTopByUsername(Mockito.any())).thenReturn(userTest);
	}

	@Test
	public void saveUserTest(){
		Mockito.when(userRepositoryTest.save(Mockito.any())).thenReturn(userTest);
	}
}
