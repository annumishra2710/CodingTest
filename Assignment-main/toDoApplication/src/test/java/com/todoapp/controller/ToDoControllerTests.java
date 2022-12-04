package com.todoapp.controller;

import java.util.Arrays;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.todoapp.toDoApplication.entity.ToDo;
import com.todoapp.toDoApplication.service.ToDoService;

@SpringBootTest
@ActiveProfiles("test")
public class ToDoControllerTests {

	@Mock
	ToDoService toDoServiceTests;

	Date createdDate = null;

	Date lastUpdatedDate = null;

	ToDo toDoTestObject1 = new ToDo(1, "TestName", "TestDescription", "TestStatus", "TestUserName", createdDate,
			lastUpdatedDate);
	ToDo toDoTestObject2 = new ToDo(1, "TestName", "TestDescription", "TestStatus", "TestUserName", createdDate,
			lastUpdatedDate);

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void addToDoTest() {
		Mockito.when(toDoServiceTests.saveToDo(Mockito.any())).thenReturn(toDoTestObject1);
	}

	@Test
	public void addToDoListTest() {
		Mockito.when(toDoServiceTests.saveToDoList(Mockito.any()))
				.thenReturn(Arrays.asList(toDoTestObject1, toDoTestObject2));
	}

	@Test
	public void getAllToDoListTest() {
		Mockito.when(toDoServiceTests.getToDOList()).thenReturn(Arrays.asList(toDoTestObject1, toDoTestObject2));
	}

	@Test
	public void findToDoByIdTest() {
		Mockito.when(toDoServiceTests.getToDoById(Mockito.anyInt())).thenReturn(toDoTestObject1);
	}

	@Test
	public void findToDoByNameTest() {
		Mockito.when(toDoServiceTests.getToDoByName(Mockito.any())).thenReturn(toDoTestObject1);
	}

	@Test
	public void findToDoByUsernameTest() {
		Mockito.when(toDoServiceTests.getToDoForUser(Mockito.any()))
				.thenReturn(Arrays.asList(toDoTestObject1, toDoTestObject2));
	}

	@Test
	public void findToDoByStatusAndUsernameTest() {
		Mockito.when(toDoServiceTests.getToDoByStatusAndUsername(Mockito.any(), Mockito.any()))
				.thenReturn(Arrays.asList(toDoTestObject1, toDoTestObject2));
	}

	@Test
	public void updatetoDoTest() {
		Mockito.when(toDoServiceTests.updateToDo(Mockito.any())).thenReturn(toDoTestObject1);
	}

	@Test
	public void deleteToDoByIdTest() {
		Mockito.when(toDoServiceTests.deleteToDo(Mockito.anyInt())).thenReturn("success");
	}

}
